package lotto.exception;

import lotto.LottoConfig;

public class LottoException {

    private final LottoConfig lottoConfig = new LottoConfig();
    private static final int ZERO_PRICE = 0;
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String TICKET_ERROR_MESSAGE = "구입 금액이 잘못 되었습니다. 티켓 한장의 가격은 1000원입니다.";
    private static final String DIGIT_ERROR_MESSAGE = "는 숫자가 아닙니다. 숫자를 입력해 주세요.";

    private boolean purchaseAmountCheckSub(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if ((amount < lottoConfig.TICKET_PRICE) || ((amount % lottoConfig.TICKET_PRICE) != ZERO_PRICE)) {
            throw new IllegalArgumentException(ERROR_PREFIX + TICKET_ERROR_MESSAGE);
        }
        return true;
    }

    public boolean purchaseAmountCheckMain(String purchaseAmount) {
        try {
            return purchaseAmountCheckSub(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + userInput + DIGIT_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
