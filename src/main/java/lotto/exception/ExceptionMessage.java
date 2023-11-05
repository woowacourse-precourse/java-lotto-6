package lotto.exception;

import static lotto.lotto.LottoSimulator.LOTTO_PRICE;

public class ExceptionMessage {
    public static final String WRONG_LOTTO_NUMBER = "[ERROR] 로또 구입 금액은 2,147,483,000이하의 수여야 합니다";
    public static final String MONEY_IS_NOT_MULTIPLE_OF_LOTTO_PRICE = String.format("[ERROR] 로또 구입 금액은 %d의 배수여야 합니다.",
            LOTTO_PRICE);
    public static final String WRONG_LOTTO_NUMBER_INPUT =
            "[ERROR] 입력을 \",\"를 기준으로 이를 포함하지 않고 잘랐을 때, 6개의 수로 나눌 수 있어야 합니다.";

    public static final String WRONG_LOTTO_NUMBER_SIZE = "[ERROR] 당첨 번호는 1 이상 45 이하여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 당첨 번호는 서로 중복될 수 없습니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String WRONG_BONUS_NUMBER_SIZE = "[ERROR] 보너스 번호는 1 이상 45 이하여야 합니다.";
}
