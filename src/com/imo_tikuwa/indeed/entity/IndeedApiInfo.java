package com.imo_tikuwa.indeed.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * IndeedAPIで取得した情報の全体を格納するクラス
 * 
 * ※Javadocは見た感じの適当な値なので公開する際は調べてから修正する！
 * 
 * @author tikuwa
 *
 */
public class IndeedApiInfo {
	
	/** APIのバージョン */
	public String version = null;
	
	/** 検索条件 */
	public String query = null;
	
	/** ？？ */
	public String location = null;
	
	/** ？？ */
	public String paginationPayload = null;
	
	/** 重複フラグ？？ */
	public String dupefilter = null;
	
	/** 強調フラグ？？ */
	public String highlight = null;
	
	/** 検索結果の取得を始める位置(offset) */
	public String start = null;
	
	/** 検索結果の取得数（limit） */
	public String end = null;
	
	/** ページ番号 */
	public String pageNumber = null;
	
	/** 検索ヒット数 */
	public String totalresults = null;
	
	/** 求人情報のリスト */
	public List<IndeedJob> results = new ArrayList<IndeedJob>();
}
