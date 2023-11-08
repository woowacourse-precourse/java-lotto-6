package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputManager {
    private final double LOTTO_COST = 1000;
    private final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final String REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    private static OutputManager outputManager;

    private OutputManager() {

    }

    public static OutputManager getInstance() {
        if (outputManager == null) {
            outputManager = new OutputManager();
        }
        return outputManager;
    }

    public void printMessage(String outputMessage) {
        System.out.println(outputMessage);
    }

    public void printLotto(List<Integer> lottoNumbers) {
        String message = lottoNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        message = "[" + message + "]";
        printMessage(message);
    }

    public void requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
    }

    public void printPurchaseMessage(int purchaseAmount) {
        System.out.println("\n" + purchaseAmount + PURCHASE_MESSAGE);
    }

    public void requestWinningNumbers() {
        System.out.println("\n" + REQUEST_WINNING_NUMBER_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println("\n" + REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printStatistic(Map<Integer, Integer> statistic) {
        final String fifth = "3개 일치 (5,000원) - " + statistic.getOrDefault(30, 0) + "개";
        final String fourth = "4개 일치 (50,000원) - " + statistic.getOrDefault(40, 0) + "개";
        final String third = "5개 일치 (1,500,000원) - " + statistic.getOrDefault(50, 0) + "개";
        final String second = "5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistic.getOrDefault(55, 0) + "개";
        final String first = "6개 일치 (2,000,000,000원) - " + statistic.getOrDefault(60, 0) + "개";

        printMessage("\n당첨 통계");
        printMessage("---");
        printMessage(fifth);
        printMessage(fourth);
        printMessage(third);
        printMessage(second);
        printMessage(first);
    }

    public void printRateOfReturn(int totalReward, int purchaseAmount) {
        double totalCost = purchaseAmount * LOTTO_COST;
        double rateOfReturn = totalReward * 100 / totalCost;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

}
