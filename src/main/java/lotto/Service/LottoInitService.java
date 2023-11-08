package lotto.Service;

import lotto.Validator.ValidatorFactory;

/**
 * 로또에 필요한 값들을 변환해주는 클래스
 */
public class LottoInitService {

    /**
     * 구입 금액을 검증하고 숫자로 반환
     * @param input 사용자가 입력한 구입 금액
     * @return 정수로 변환된 구입 금액
     */
    public Integer inputAmountToNumber(String input) {
        String validatedInput = ValidatorFactory.forInputAmount().valid(input);

        return Integer.parseInt(validatedInput);
    }
}
