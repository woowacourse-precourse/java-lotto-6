package view;

import domain.IncomeRate;
import domain.LottoResult;
import domain.Rank;

public class OutputLottoResultView {
    private static final String NEW_LINE = "\n";
    private static final String HEAD_MESSAGE = "당첨 통계" + NEW_LINE + "---";
    private static final String INCOME_RATE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoResult(LottoResult lottoResult, IncomeRate incomeRate) {
        System.out.println(HEAD_MESSAGE);

        for (Rank rank : Rank.values()) {
            int winningNumberCount = rank.getWinningNumberCount();
            int prize = rank.getPrize();
            int eachRankResult = lottoResult.getEachRankResult(rank);
            String messageFormat = rank.getMessageFormat();

            System.out.printf((messageFormat + NEW_LINE), winningNumberCount, String.format("%,d", prize), eachRankResult);
        }

        System.out.printf(INCOME_RATE, incomeRate.getRate());

    }

}
