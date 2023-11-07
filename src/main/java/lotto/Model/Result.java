package lotto.Model;

import lotto.Lotto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    public static Map<String, Integer> calculateResults(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> results = initializeResults();

        for (Lotto ticket : lottoTickets) {
            int matchingCount = calculateMatchingCount(ticket, winningNumbers, bonusNumber);
            results.put(String.valueOf(matchingCount), results.getOrDefault(String.valueOf(matchingCount), 0) + 1);
        }

        return results;
    }

    public static int calculateMatchingCount(Lotto ticket, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> numbers = ticket.getNumbers();
        long matchingCount = numbers.stream().filter(number -> winningNumbers.contains(number)).count();

        if (matchingCount == 6) {
            return 6;
        } else if (matchingCount == 5 && numbers.contains(bonusNumber)) {
            return 51;
        } else {
            return (int) matchingCount;
        }
    }

    public static Map<String, Integer> initializeResults() {
        Map<String, Integer> results = new HashMap<>();
        results.put("0", 0);
        results.put("1", 0);
        results.put("2", 0);
        results.put("3", 0);
        results.put("4", 0);
        results.put("5", 0);
        results.put("5.1", 0);
        results.put("6", 0);
        return results;
    }



    public static double resultsToProfitRate(Map<String, Integer> results) {

        double totalPrize = calculateTotalPrize(results);
        int totalPurchaseAmount = calculateTotalPurchaseAmount(results);
        double profitRate = (totalPrize / totalPurchaseAmount) * 100;
        return profitRate;
    }

    public static double calculateTotalPrize(Map<String, Integer> results) {
        return results.entrySet().stream().mapToDouble(entry -> {
            String prize = Prize.getPrize(entry.getKey());
            int prizeWithoutCommas = Integer.parseInt(prize.replaceAll(",", ""));
            return entry.getValue() * prizeWithoutCommas;
        }).sum();
    }

    public static int calculateTotalPurchaseAmount(Map<String, Integer> results) {
        return results.values().stream().mapToInt(Integer::intValue).sum() * 1000;
    }
}