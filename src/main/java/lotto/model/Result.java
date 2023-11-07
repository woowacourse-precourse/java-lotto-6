package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Result {
    public static Map<String, Integer> getResultWinCount(List<Lotto> lotties, List<Integer> parseWinNumbers,
            int parseBonusNumber,
            int parseMoney) {

        boolean hasBonusNumber = false;
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < lotties.size(); i++) {
            int correctCount = 0;
            Lotto lotto = lotties.get(i);
            correctCount = checkWinNumber(lotto, correctCount, parseWinNumbers);
            hasBonusNumber = checkBonusNumber(lotto, parseBonusNumber);
            result = saveCount(result, correctCount, hasBonusNumber);
        }
        return result;

    }

    public static int checkWinNumber(Lotto lotto, int correctCount, List<Integer> parseWinNumbers) {
        final int INCORRECT_NUMBER = -1;
        for (int j = 0; j < lotto.getLotto().size(); j++) {
            if (lotto.getLotto().indexOf(parseWinNumbers.get(j)) != INCORRECT_NUMBER) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public static boolean checkBonusNumber(Lotto lotto, int parseBounusNumber) {
        if (lotto.getLotto().contains(parseBounusNumber)) {
            return true;
        }
        return false;
    }

    public static Map<String, Integer> saveCount(Map<String, Integer> result, int correctCount,
            boolean hasBonusNumber) {

        if (correctCount == 3) {
            result.put("three", result.getOrDefault(result.get("three"), 0) + 1);
        }

        if (correctCount == 4) {
            result.put("four", result.getOrDefault(result.get("four"), 0) + 1);
        }

        if (correctCount == 5) {
            result.put("five", result.getOrDefault(result.get("five"), 0) + 1);
        }

        if (correctCount == 5 && hasBonusNumber) {
            result.put("fiveBonus", result.getOrDefault(result.get("fiveBonus"), 0) + 1);
        }

        if (correctCount == 6) {
            result.put("six", result.getOrDefault(result.get("six"), 0) + 1);
        }
        return result;
    }
}
