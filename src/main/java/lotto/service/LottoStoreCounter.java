package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class LottoStoreCounter {
    private final int lottoPrice = 1000;

    public int counter() {
        int numberOfIssues = paying();

        return numberOfIssues;
    }

    private int paying() {
        String money;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                money = Console.readLine();
                validate(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(money) / lottoPrice;
    }

    private void validate(String money) {
        validateNumber(money);
        validateThousandUnits(money);
    }

    private void validateNumber(String money) {
        try {
            Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 가능합니다.");
        }
    }

    private void validateThousandUnits(String money) {
        if (Integer.parseInt(money) % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 천 단위만 가능합니다.");
        }
    }
}
