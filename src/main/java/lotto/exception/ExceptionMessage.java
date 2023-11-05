package lotto.exception;

import static lotto.simulation.LottoConstant.LOTTO_PRICE;

public class ExceptionMessage {
    public static final String WRONG_LOTTO_NUMBER = "[ERROR] 로또 구입 금액은 2,147,483,000이하의 수여야 합니다";
    public static final String MONEY_IS_NOT_MULTIPLE_OF_LOTTO_PRICE = String.format("[ERROR] 로또 구입 금액은 %d의 배수여야 합니다.",
            LOTTO_PRICE);
}
