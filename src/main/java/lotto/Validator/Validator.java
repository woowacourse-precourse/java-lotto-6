package lotto.Validator;

import static lotto.config.LottoConfig.LOTTO_MAX_VALUE;
import static lotto.config.LottoConfig.LOTTO_MIN_VALUE;

import java.util.regex.Pattern;

/**
 * 검증 클래스의 공통 기능들을 정의해둔 추상클래스
 *
 * @param <T> 검증 클래스가 확인할 자료형
 */
public abstract class Validator<T> {

    public abstract T valid(T input);

    /**
     * 문자열이 0~9 사이의 문자로 이루어져 있는지 확인
     * @param input 확인할 문자열
     * @return 숫자로만 이루어져 있으면 true, 아니면 false
     */
    protected boolean isNumber(String input) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(input).matches();
    }

    /**
     * 1에서 45 사이의 숫자인지 확인
     * @param number 확인할 숫자
     * @return 1~45 사이의 숫자면 true, 아니면 false
     */
    protected boolean isLottoNumber(int number) {
        return LOTTO_MIN_VALUE.getValue() <= number && number <= LOTTO_MAX_VALUE.getValue();
    }
}
