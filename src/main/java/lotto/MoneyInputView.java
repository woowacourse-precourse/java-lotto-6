package lotto;

import camp.nextstep.edu.missionutils.Console;

public class MoneyInputView {

    private static final int ZERO = 0;
    private static final int ONE_ISSUE_LOTTO = 1000;
    private String input;
    private int money;
    private int issueCount;

    public MoneyInputView() {
        validate();
    }

    private void validate() {
        input = Console.readLine();
        try {
            nonZero();
            leastOneIssue();
            nonRemainder();
            makeIssueLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validate();
        }
    }


    private void nonZero() {
        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException("[ERROR] 0 이 아닌 숫자를 입력해야 합니다.");
        }
        money = Integer.parseInt(input);
    }

    private void leastOneIssue() {
        if (ONE_ISSUE_LOTTO > money) {
            throw new IllegalArgumentException("[ERROR] 최소한 1000원 이상이어야 합니다.");
        }
    }

    private void nonRemainder() {
        int remainder = Integer.parseInt(input) % ONE_ISSUE_LOTTO;
        if (ZERO < remainder) {
            throw new IllegalArgumentException("[ERROR] 나누어 떨어져야 합니다.");
        }
    }


    private void makeIssueLotto() {
        issueCount = money / ONE_ISSUE_LOTTO;
    }

    public int getIssueCount() {
        return issueCount;
    }
}
