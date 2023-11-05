package lotto.domain;

import lotto.message.WinningMessage;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.message.GuideMessage.RATE_OF_PROFIT_MESSAGE;
import static lotto.message.GuideMessage.WINNING_RESULT_MESSAGE;

public class WinningChecker {
    private double totalWinningAmount;
    private Map<Integer, Integer> rankInfo;

    public WinningChecker() {
        this.totalWinningAmount = 0;
        this.rankInfo = new HashMap<>();
    }

    public static WinningChecker createWinningChecker() {
        return new WinningChecker();
    }

    public void checkWinning(Customer customer) {
        List<Result> results = customer.getResults();
        calculateTotalWinningAmount(results);
        calculateRank(results);
    }

    private void calculateTotalWinningAmount(List<Result> results) {
        for (Result result : results) {
            result.getWinningInfo()
                    .ifPresent(winningInfo -> this.totalWinningAmount += winningInfo.getAmount());
        }
    }

    private void calculateRank(List<Result> results) {
        for (Result result : results) {
            result.getWinningInfo()
                    .ifPresent(winningInfo -> this.rankInfo.put(winningInfo.getRank(),
                            this.rankInfo.getOrDefault(winningInfo.getRank(), 0) + 1));
        }

    }

    public void printWinningInfo() {
        System.out.println(WINNING_RESULT_MESSAGE);
        Arrays.stream(WinningMessage.values())
                .map(winningMessage -> createWinningMessage(winningMessage))
                .forEach(message -> System.out.println(message));
    }

    private String createWinningMessage(WinningMessage winningMessage) {
        return String.format(winningMessage.getContent(),
                this.rankInfo.getOrDefault(winningMessage.getRank(), 0));
    }

    public void printRateOfProfit(Customer customer) {
        double rateOfProfit = (totalWinningAmount / customer.getPayment()) * 100;
        DecimalFormat df = new DecimalFormat("#.##");
        String roundedNumber = df.format(rateOfProfit);
        System.out.println(String.format(RATE_OF_PROFIT_MESSAGE.toString(), roundedNumber));
    }
}
