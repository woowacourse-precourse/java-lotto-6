package lotto.ui;

import lotto.domain.Result;

import java.util.List;

public class OutputView {

    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumber(List<Integer> newLottoNumber){
        System.out.println(newLottoNumber);
    }

    public void printResult(List<List<Integer>> lottoNumbers){
        System.out.println("당첨 통계");
        System.out.println("---");
        double revenue = 0;
        for (Result result : Result.values()) {
            System.out.println(result.getResult() + " - " + result.getMatch() + "개");
            revenue += result.getMatch() * result.getMoney();
        }

        double revenuePercent = revenue / (lottoNumbers.size() * 1000) * 100;

        System.out.println("총 수익률은 " + Math.round(revenuePercent * 100) / 100.0 + "%입니다.");
    }
}
