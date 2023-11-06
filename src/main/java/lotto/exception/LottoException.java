package lotto.exception;

import lotto.Constants;

import java.util.List;

public class LottoException {

    public void validateLottoNumbers(List<Integer> numbers) {

    }

    public void validateBonusNumber(List<Integer> inputNumbers, int bonusNumber) {

    }

    // lotto numbers
    public void validInputLottoNumbers(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            char n = numbers.charAt(i);
            if (!(Character.isDigit(n)) || n == ',') {
                throw new IllegalArgumentException(Constants.ERROR + "로또 번호 입력은 숫자와 콤마(,)로 구성되어야 합니다.");
            }
        }
    }
}
