package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {
    public static Integer LOTTO_COUNT;
    public static final Integer LOTTO_PRICE = 1_000;
    private static final String LOTTO_PRICE_ERROR_MESSAGE = "입력한 금액은 로또 한 장 가격(1,000원)의 배수여야 합니다.";
    public static Integer inputMoney() {
        Integer money = Integer.valueOf(Console.readLine());
        validateLottoPrice(money);
        return money;
    }

    private static void validateLottoPrice(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    private static Integer calculateLottoCount(Integer money) {
        LOTTO_COUNT = money / LOTTO_PRICE;
        return LOTTO_COUNT;
    }


}
