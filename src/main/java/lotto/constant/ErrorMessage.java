package lotto.constant;

import static lotto.constant.NumericConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.NumericConstant.LOTTO_PRICE;
import static lotto.constant.NumericConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumericConstant.MIN_LOTTO_NUMBER;

public abstract class ErrorMessage {
    private static final String ERROR_HEADER = "[ERROR] ";
    public static final String ENTER_PROPER_NATURAL_NUMBER = ERROR_HEADER + "10억 이하의 자연수 값을 입력해주세요";
    public static final String NOT_DIVISIBLE_BY_LOTTO_PRICE
            = ERROR_HEADER + String.format("%d으로 나누어 떨어지는 값을 입력해 주세요.", LOTTO_PRICE);
    
    public static final String ENTER_PROPER_LOTTO_NUMBER
            = ERROR_HEADER + String.format("%d 부터 %d 사이의 번호를 입력하여 주세요", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);

    public static final String ENTER_PROPER_LOTTO_COUNT
            = ERROR_HEADER + String.format("로또 번호는 %d개만 입력 가능합니다.", LOTTO_NUMBER_COUNT);

    public static final String EXIST_DUPLICATED_NUMBER = ERROR_HEADER + "중복된 숫자가 존재합니다.";

    public static final String WINNING_LOTTO_CONTAIN_BONUS_NUMBER
            = ERROR_HEADER + "보너스 번호는 당첨 로또와 겹칠 수 없습니다.";
}
