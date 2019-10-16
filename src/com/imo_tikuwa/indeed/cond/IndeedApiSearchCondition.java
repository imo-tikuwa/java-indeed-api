package com.imo_tikuwa.indeed.cond;

public class IndeedApiSearchCondition {

	/** パブリッシャー ID */
	private String publisher;
	
	/** バージョン（2で固定）*/
	private String v = "2";
	
	/** フォーマット（xmlで固定）*/
	private String format = "xml";
	
	/** コールバック */
	private String callback;
	
	/** クエリー */
	private String q;
	
	/** 勤務地 */
	private String l;
	
	/** 関連性または日付順で並び替え */
	private String sort;
	
	/** 検索に用いた勤務地からの直線距離 */
	private String radius;
	
	/** サイトのタイプ */
	private String st;
	
	/** 職種 */
	private String jt;
	
	/** 検索結果オフセット */
	private String start;
	
	/** 一回の検索で得られる検索結果の最大数 */
	private String limit;
	
	/** 検索において遡る日数 */
	private String fromage;
	
	/** この値を 1 に設定すると q に表示されているスニペットの文字が太字になります */
	private String highlight;
	
	/** 重複した検索結果をフィルターします */
	private String filter;
	
	/** もし latlong が 1 の場合、 個々の求人検索結果の latitude と longitude 情報を返します */
	private String latlong;
	
	/** 指定された国における検索 */
	private String co;
	
	/** チャンネル名： グループ API が特定のチャンネルを要求します */
	private String chnl;
	
	/** 求人結果が表示されるエンドユーザーIP 番号 */
	private String userip;
	
	/** 求人結果が表示されるエンドユーザーのユーザーエージェント（ブラウザ） */
	private String useragent;

	/**
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher セットする publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return v
	 */
	public String getV() {
		return v;
	}

	/**
	 * @return format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @return callback
	 */
	public String getCallback() {
		return callback;
	}

	/**
	 * @param callback セットする callback
	 */
	public void setCallback(String callback) {
		this.callback = callback;
	}

	/**
	 * @return q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * 検索条件
	 * ※UTF-8を使用する必要あり
	 * ※URLエンコードは不要
	 * 
	 * @param q セットする q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * @return l
	 */
	public String getL() {
		return l;
	}

	/**
	 * @param l セットする l
	 */
	public void setL(String l) {
		this.l = l;
	}

	/**
	 * @return sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort セットする sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return radius
	 */
	public String getRadius() {
		return radius;
	}

	/**
	 * @param radius セットする radius
	 */
	public void setRadius(String radius) {
		this.radius = radius;
	}

	/**
	 * @return st
	 */
	public String getSt() {
		return st;
	}

	/**
	 * @param st セットする st
	 */
	public void setSt(String st) {
		this.st = st;
	}

	/**
	 * @return jt
	 */
	public String getJt() {
		return jt;
	}

	/**
	 * @param jt セットする jt
	 */
	public void setJt(String jt) {
		this.jt = jt;
	}

	/**
	 * @return start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start セットする start
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * @param limit セットする limit
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * @return fromage
	 */
	public String getFromage() {
		return fromage;
	}

	/**
	 * @param fromage セットする fromage
	 */
	public void setFromage(String fromage) {
		this.fromage = fromage;
	}

	/**
	 * @return highlight
	 */
	public String getHighlight() {
		return highlight;
	}

	/**
	 * @param highlight セットする highlight
	 */
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	/**
	 * @return filter
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * @param filter セットする filter
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}

	/**
	 * @return latlong
	 */
	public String getLatlong() {
		return latlong;
	}

	/**
	 * @param latlong セットする latlong
	 */
	public void setLatlong(String latlong) {
		this.latlong = latlong;
	}

	/**
	 * @return co
	 */
	public String getCo() {
		return co;
	}

	/**
	 * @param co セットする co
	 */
	public void setCo(String co) {
		this.co = co;
	}

	/**
	 * @return chnl
	 */
	public String getChnl() {
		return chnl;
	}

	/**
	 * @param chnl セットする chnl
	 */
	public void setChnl(String chnl) {
		this.chnl = chnl;
	}

	/**
	 * @return userip
	 */
	public String getUserip() {
		return userip;
	}

	/**
	 * @param userip セットする userip
	 */
	public void setUserip(String userip) {
		this.userip = userip;
	}

	/**
	 * @return useragent
	 */
	public String getUseragent() {
		return useragent;
	}

	/**
	 * ユーザーエージェント
	 * ※UTF-8を使用する必要あり
	 * ※URLエンコードは不要
	 * 
	 * @param useragent セットする useragent
	 */
	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}
}
