package lotto.Domain;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Budget {

    public static final String NULL_OR_EMPTY_MESSAGE = "[ERROR] 값을 입력해주세요";
    public static final String EMPTY = "";
    public static final String THOUSANDS_MULTIPLE_MESSAGE = "[ERROR] 1000의 배수를 입력해주세요";
    public static final String THOUSANDS_MULTIPLE_REGEX = "^[1-9][0-9]*000$";
    public static final int LOTTO_PRICE = 1000;
    private int budgetAmount;

    public Budget(String budget) throws IllegalArgumentException {
        validateNullOrEmpty(budget);
        validateBudgetInThousands(budget);
        budgetAmount = Integer.parseInt(budget);
    }

    private static void validateNullOrEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.equals(EMPTY)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_MESSAGE);
        }
    }

    private static void validateBudgetInThousands(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(THOUSANDS_MULTIPLE_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(THOUSANDS_MULTIPLE_MESSAGE);
        }
    }

    public int calculateLottoCount() {
        return budgetAmount / LOTTO_PRICE;
    }

    public double calculateReturnRate(Map<Rank, Integer> rankCount) {
        long money = 0;
        for (Rank rank : Rank.values()) {
            money += rank.getPrizeAmount() * rankCount.getOrDefault(rank, 0);
        }
        double returnRate = ((double) money / budgetAmount) * 100;
        return Math.round(returnRate * 10.0) / 10.0;
    }
}
