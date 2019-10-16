package com.imo_tikuwa.indeed.entity;

/**
 * IndeedAPIで取得した情報のうち1件辺りの求人情報を格納するクラス
 * 
 * ※Javadocは見た感じの適当な値なので公開する際は調べてから修正する！
 * 
 * @author tikuwa
 *
 */
public class IndeedJob {
	
	/** 求人タイトル */
	public String jobtitle = null;
	
	/** 会社名 */
	public String company = null;
	
	/** 所在地 */
	public String city = null;
	
	/** 所在コード */
	public String state = null;
	
	/** 国コード */
	public String country = null;
	
	/** フォーマットされた地点情報（短） */
	public String formattedLocation = null;
	
	/** ソース */
	public String source = null;
	
	/** 日時 */
	public String date = null;
	
	/** 求人内容 */
	public String snippet = null;
	
	/** Indeed内の求人URL */
	public String url = null;
	
	/** aタグに追加するonmousedownの値 */
	public String onmousedown = null;
	
	/** ジョブキー */
	public String jobkey = null;
	
	/** スポンサー */
	public String sponsored = null;
	
	/** 期限切れフラグ */
	public String expired = null;
	
	/** ？？ */
	public String indeedApply = null;
	
	/** フォーマットされた地点情報（長） */
	public String formattedLocationFull = null;
	
	/** フォーマットされた相対時間 */
	public String formattedRelativeTime = null;
	
	/** 駅名 */
	public String stations = null;
}
