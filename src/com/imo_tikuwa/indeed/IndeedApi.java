package com.imo_tikuwa.indeed;

import static com.imo_tikuwa.indeed.Constants.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.imo_tikuwa.indeed.cond.IndeedApiSearchCondition;
import com.imo_tikuwa.indeed.entity.IndeedApiInfo;
import com.imo_tikuwa.indeed.entity.IndeedJob;
import com.imo_tikuwa.indeed.exception.IndeedApiException;

public class IndeedApi {

	/**
	 * IndeedのAPIに渡すURLを取得する
	 * @param condition
	 * @return
	 * @throws IndeedApiException 
	 */
	private static String createIndeedApiUrl(IndeedApiSearchCondition condition) throws IndeedApiException {

		StringBuffer sb = new StringBuffer();

		sb.append("http://api.indeed.com/ads/apisearch?");
		String publisher = (condition.getPublisher() != null) ? condition.getPublisher() : "";
		sb.append("publisher=" + publisher);
		if (condition.getV() != null) {
			sb.append("&v=" + condition.getV());
		}
		if (condition.getFormat() != null) {
			sb.append("&format=" + condition.getFormat());
		}
		if (condition.getCallback() != null) {
			sb.append("&callback=" + condition.getCallback());
		}
		try {
			sb.append("&q=" + URLEncoder.encode(condition.getQ(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new IndeedApiException("qのエンコーディングエラー");
		}
		if (condition.getL() != null) {
			sb.append("&l=" + condition.getL());
		}
		if (condition.getSort() != null) {
			sb.append("&sort=" + condition.getSort());
		}
		if (condition.getRadius() != null) {
			sb.append("&radius=" + condition.getRadius());
		}
		if (condition.getSt() != null) {
			sb.append("&st=" + condition.getSt());
		}
		if (condition.getJt() != null) {
			sb.append("&jt=" + condition.getJt());
		}
		if (condition.getStart() != null) {
			sb.append("&start=" + condition.getStart());
		}
		if (condition.getLimit() != null) {
			sb.append("&limit=" + condition.getLimit());
		}
		if (condition.getFromage() != null) {
			sb.append("&fromage=" + condition.getFromage());
		}
		if (condition.getHighlight() != null) {
			sb.append("&highlight=" + condition.getHighlight());
		}
		if (condition.getFilter() != null) {
			sb.append("&filter=" + condition.getFilter());
		}
		if (condition.getLatlong() != null) {
			sb.append("&latlong=" + condition.getLatlong());
		}
		if (condition.getCo() != null) {
			sb.append("&co=" + condition.getCo());
		}
		if (condition.getChnl() != null) {
			sb.append("&chnl=" + condition.getChnl());
		}
		if (condition.getUserip() != null) {
			sb.append("&userip=" + condition.getUserip());
		}
		if (condition.getUseragent() != null) {
			try {
				sb.append("&useragent=" + URLEncoder.encode(condition.getUseragent(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new IndeedApiException("useragentのエンコーディングエラー");
			}
		}

		return sb.toString();
	}

	/**
	 * Indeedから求人情報を検索してJavaのオブジェクトに格納したものを取得する
	 * @param condition
	 * @return
	 * @throws IndeedApiException
	 */
	public static IndeedApiInfo getIndeedJobs(IndeedApiSearchCondition condition) throws IndeedApiException {

		// 引数の検索条件を元にAPIにアクセスするURLを取得する
		String indeedApiUrl = createIndeedApiUrl(condition);

		// Indeedに対してAPI通信を行い求人情報を取得する
		HttpURLConnection conn = null;
		Document document = null;
		try {

			URL url = new URL(indeedApiUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setInstanceFollowRedirects(false);
			conn.setRequestProperty("Accept-Language", "ja;q=0.7,en;q=0.3");
			conn.connect();
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(conn.getInputStream());

		} catch (Exception e) {

			if (conn != null) {
				conn.disconnect();
			}
			e.printStackTrace();
			throw new IndeedApiException("APIリクエスト中のエラー");
		}
//		catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (ProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		}

		// XMLのルート要素とその子要素を取得
		Element root = document.getDocumentElement();
		NodeList rootChildren = root.getChildNodes();
		
		// レスポンスXMLのエラーチェック
		for (int i = 0; i < rootChildren.getLength(); i++) {
			Node node = rootChildren.item(i);
			Element element = (Element) node;
			if (ERROR_NODE_NAME.equals(element.getNodeName())) {
				throw new IndeedApiException("APIからのエラーメッセージ『" + element.getTextContent() + "』");
			}
		}

		// XMLデータを格納するオブジェクトを作成
		IndeedApiInfo indeedApiInfo = new IndeedApiInfo();
		@SuppressWarnings("rawtypes")
		Class c = indeedApiInfo.getClass();
		try {
			indeedApiInfo.version = root.getAttribute("version");
			for (int i = 0; i < rootChildren.getLength(); i++) {
				Node node = rootChildren.item(i);

				// クエリ層の情報を取得
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;

					if (FIRST_NODE_NAME_LIST.contains(element.getNodeName())) {

						// 求人情報を含むノード名のときネストして求人情報を取得する
						if ("results".equals(element.getNodeName())) {

							NodeList jobs = node.getChildNodes();
							for (int j = 0; j < jobs.getLength(); j++) {

								// リフレクションを使用して求人情報をクラスに格納する
								IndeedJob indeedJob = new IndeedJob();
								@SuppressWarnings("rawtypes")
								Class c2 = indeedJob.getClass();

								Node joblist = jobs.item(j);
								NodeList jobdata = joblist.getChildNodes();
								for (int k = 0; k < jobdata.getLength(); k++) {

									Element job = (Element)jobdata.item(k);

									// ノード名のリストに含まれていないノードはセキュリティ上の観点からスキップしておく
									if (!JOB_NODE_NAME_LIST.contains(job.getNodeName())) {
										continue;
									}
									Field f = c2.getField(job.getNodeName());
									f.set(indeedJob, job.getTextContent());
								}
								indeedApiInfo.results.add(indeedJob);
							}

						} else {

							// リフレクションを使用して求人検索情報をクラスに格納する
							Field f = c.getField(element.getNodeName());
							f.set(indeedApiInfo, element.getTextContent());
						}
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new IndeedApiException("indeedApiInfoオブジェクト作成中のエラー");

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
//		catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}

		return indeedApiInfo;
	}
}
