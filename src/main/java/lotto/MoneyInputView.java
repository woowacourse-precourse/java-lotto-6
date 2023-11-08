package lotto;

import static lotto.ErrorMessage.LEAST_ONE_ISSUE_ERROR;
import static lotto.ErrorMessage.NON_REMAINDER_ERROR;
import static lotto.ErrorMessage.NON_ZERO_ERROR;
import static lotto.ErrorMessage.NUMERIC_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class MoneyInputView {

    private static final int ZERO = 0;
    private static final int ONE_ISSUE_LOTTO = 1000;

    private static final String regex = "^[0-9]+$";
    private static final Pattern pattern = Pattern.compile(regex);
    private String input;
    private int money;
    private int issueCount;

    public MoneyInputView() {
        validate();
    }

    private void validate() {
        input = Console.readLine();
        try {
            numerics();
            nonZero();
            leastOneIssue();
            nonRemainder();
            makeIssueLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validate();
        }
    }

    private void numerics() {
        boolean isNumeric = pattern.matcher(input).matches();
        if (!isNumeric) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    private void nonZero() {
        if (Integer.parseInt(input) == ZERO) {
            throw new IllegalArgumentException(NON_ZERO_ERROR);
        }
        money = Integer.parseInt(input);
    }

    private void leastOneIssue() {
        if (ONE_ISSUE_LOTTO > money) {
            throw new IllegalArgumentException(LEAST_ONE_ISSUE_ERROR);
        }
    }

    private void nonRemainder() {
        int remainder = Integer.parseInt(input) % ONE_ISSUE_LOTTO;
        if (ZERO < remainder) {
            throw new IllegalArgumentException(NON_REMAINDER_ERROR);
        }
    }


    private void makeIssueLotto() {
        issueCount = money / ONE_ISSUE_LOTTO;
    }

    public int getIssueCount() {
        return issueCount;
    }
}
