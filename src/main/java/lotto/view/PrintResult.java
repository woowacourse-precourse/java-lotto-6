package lotto.view;

import lotto.controller.CalculateController;
import lotto.controller.LottoController;
import lotto.model.Rankings;

import java.util.Arrays;

public class PrintResult {


    private LottoController lottoController = new LottoController();
    int[] resultsOfPrize;
    double resultOfProfitRate;
    public PrintResult(int[] resultsOfPrize,double resultOfProfitRate) {
        this.resultsOfPrize = resultsOfPrize;
        this.resultOfProfitRate = resultOfProfitRate;
    }

    public String printStartText() {
        return "당첨 통계\n" +
                "---";
    }

    public String printResults() {
        Rankings.RankingData[] rankingData = Rankings.RankingData.values();
        StringBuilder results = new StringBuilder();
        for (Rankings.RankingData values:
             rankingData) {
            results.append(values.getRankings() + resultsOfPrize[values.ordinal()] + "개 \n");
        }
        return results.toString();
    }
    public String printProfitRate() {
        return "총 수익률은 " + resultOfProfitRate + "% 입니다.";
    }
    public void run() {
        System.out.println(printStartText());
        System.out.println(printResults());
        System.out.println(printProfitRate());
    }
}
