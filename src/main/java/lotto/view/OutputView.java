package lotto.view;

import java.util.Map;
import lotto.utils.constant.InformationMessage;
import lotto.utils.constant.ProcessMessage;
import lotto.utils.constant.Rank;

public class OutputView {
    public static void printWinningResult(Map<Rank, Integer> result) {
        System.out.printf(ProcessMessage.WINNING_RESULT.getMessage());
        System.out.printf(ProcessMessage.DIVISION_MARK.getMessage());
        printRankInformation(result, Rank.FIFTH);
        printRankInformation(result, Rank.FOURTH);
        printRankInformation(result, Rank.THIRD);
        printRankInformationWithBonus(result, Rank.SECOND);
        printRankInformation(result, Rank.FIRST);
    }

    public static void printRankInformation(Map<Rank, Integer> result, Rank rank) {
        System.out.printf(InformationMessage.MATCH_NUMBER.getMessage(), rank.getMatchNumberCount(),
                rank.getWinningMoney(), result.get(rank));
    }

    public static void printRankInformationWithBonus(Map<Rank, Integer> result, Rank rank) {
        System.out.printf(InformationMessage.MATCH_NUMBER_BONUS.getMessage(), rank.getMatchNumberCount(),
                rank.getWinningMoney(), result.get(rank));
    }

    public static void printGetMoneyMessage() {
        System.out.printf(ProcessMessage.GET_MONEY.getMessage());
    }

    public static void printGetWinningNumberMessage() {
        System.out.printf(ProcessMessage.GET_WINNING_NUMBER.getMessage());
    }

    public static void printGetBonusNumberMessage() {
        System.out.printf(ProcessMessage.GET_BONUS_NUMBER.getMessage());
    }

    public static void printCommonString(String string) {
        System.out.println(string);
    }

    public static void printLottoCount(int money) {
        System.out.printf(InformationMessage.BUY.getMessage(), money);
    }

    public static void printLottoProfit(double profit) {
        System.out.printf(InformationMessage.PROFIT.getMessage(), profit);
    }
}