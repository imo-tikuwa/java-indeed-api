package com.imo_tikuwa.indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {

	/** プライベートコンストラクタ */
	private Constants() {
	}

	/** 検索結果情報が格納されているノード名のリスト */
	public static final List<String> FIRST_NODE_NAME_LIST;

	/** 求人情報が格納されているノード名のリスト */
	public static final List<String> JOB_NODE_NAME_LIST;

	/** エラー時のレスポンスXML内に含まれるエラーのノード名 */
	public static final String ERROR_NODE_NAME;

	/** API URL */
	public static final String API_URL_BASE;

	static {

		List<String> firstNodeNameList = new ArrayList<String>(Arrays.asList("query", "location", "paginationPayload", "dupefilter", "highlight", "start", "end", "pageNumber", "totalresults", "results"));
		FIRST_NODE_NAME_LIST = Collections.unmodifiableList(firstNodeNameList);

		List<String> jobNodeNameList = new ArrayList<String>(Arrays.asList("jobtitle", "company", "city", "state", "country", "formattedLocation", "source", "date", "snippet", "url", "onmousedown", "jobkey", "sponsored", "expired", "indeedApply", "formattedLocationFull", "formattedRelativeTime", "stations"));
		JOB_NODE_NAME_LIST = Collections.unmodifiableList(jobNodeNameList);

		ERROR_NODE_NAME = "error";

		API_URL_BASE = "http://api.indeed.com/ads/apisearch?";
	}


}
