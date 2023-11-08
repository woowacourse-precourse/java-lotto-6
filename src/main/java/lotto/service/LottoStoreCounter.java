package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class LottoStoreCounter {
    private final String salesMessage = "구입금액을 입력해 주세요.";
    private final String errorMessageInputType = "[ERROR] 금액은 숫자만 가능합니다.";
    private final String errorMessageUnit = "[ERROR] 금액은 천 단위만 가능합니다.";
    private final int lottoPrice = 1000;

    public long counter() {
        long numberOfIssues = paying();

        return numberOfIssues;
    }

    private long paying() {
        String money;
        while (true) {
            try {
                System.out.println(salesMessage);
                money = Console.readLine();
                validate(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Long.parseLong(money) / lottoPrice;
    }

    private void validate(String money) {
        validateNumber(money);
        validateThousandUnits(money);
    }

    private void validateNumber(String money) {
        try {
            Long.parseLong(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(errorMessageInputType);
        }
    }

    private void validateThousandUnits(String money) {
        if (Long.parseLong(money) % lottoPrice != 0) {
            throw new IllegalArgumentException(errorMessageUnit);
        }
    }
}
