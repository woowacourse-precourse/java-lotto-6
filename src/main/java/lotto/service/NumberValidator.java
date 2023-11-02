package lotto.service;

import lotto.domain.LottoNumbers;

public class NumberValidator {

    public void validateNumberInRange(int lottoNumber) {
        if (lottoNumber < LottoNumbers.MIN_LOTTO_NUMBER.getNumber()
                || lottoNumber > LottoNumbers.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45까지의 숫자만 입력할 수 있습니다.");
        }
    }
}
