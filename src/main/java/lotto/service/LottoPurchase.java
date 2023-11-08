package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import exception.ErrorCode;

public class LottoPurchase {
    private String userPurchase;

    public LottoPurchase(String userPurchase) {
        this.userPurchase = userPurchase;
    }

    public LottoPurchase() {
        super();
    }

    public int inputLottoPurchase() {
        return isDivisibleBy1000(validateNumber());
    }

    public String inputLottoString() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int validateNumber( ) {
        try {
            return Integer.parseInt(userPurchase);
        } catch (NumberFormatException numberFormatException) {
            throw new CustomException(ErrorCode.PARS_EERROR_TYPE);
        }
    }

    private int isDivisibleBy1000(int number) {
        if (number % 1000 != 0) {
            throw new CustomException(ErrorCode.DIVISIBILITY_ERROR);
        }
        return (number / 1000);
    }
}
