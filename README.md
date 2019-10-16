# java-indeed-api

## 使い方
1. IndeedApiSearchConditionクラスでAPIに渡す情報をセット
    1. 各セッターの名称は[API](https://ads.indeed.com/jobroll/xmlfeed)のパラメータに寄せてあるのでそちらを確認してください
1. IndeedApi.getIndeedJobsでAPIに接続し求人情報の取得を行います
1. 正常に動作すれば戻り値としてIndeedApiInfoオブジェクトを返します

## Javaバージョン、ライブラリについて
- java6で動作確認済みです。
- 外部のjarライブラリは特に使用しておらず単体で動作可能となっています。

## サンプルコード
```Java
    // IndeedAPIとの通信を行う際の検索条件を作成する
    IndeedApiSearchCondition condition = new IndeedApiSearchCondition();
    condition.setPublisher("[indeed publisher id]");
    condition.setQ("Webプログラマ");
    condition.setUserip("127.0.0.1");
    condition.setUseragent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
    condition.setCo("jp");

    // Indeedから求人情報を取得する
    IndeedApiInfo info = null;
    try {
      info = IndeedApi.getIndeedJobs(condition);
    } catch (IndeedApiException e) {
      e.printStackTrace();
    }

    // 結果をコンソールに出力
    if (info != null && info.results != null && info.results.size() > 0) {
      for (IndeedJob job : info.results) {
        System.out.println("jobtitle : " + job.jobtitle);
        System.out.println("company  : " + job.company);
        System.out.println("location : " + job.formattedLocationFull);
        System.out.println("date     : " + job.date);
        System.out.println("stations : " + job.stations);
        System.out.println("snipet   : " + job.snippet);
        System.out.println("////////////////////");
      }
    }
```

## メモ
2019/04/03
- ひさびさにプロジェクト開いて動かしたらQパラメータがURLエンコードしてないとエラーになったため、ソース内でURLエンコードするよう修正
- それに伴いユーザーエージェントも同様にソース内でエンコードするよう修正
