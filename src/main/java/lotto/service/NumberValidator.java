package lotto.service;

import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.LottoNumbers;

public class NumberValidator {

    private static final String NUMBER = "^[0-9]+$";

    public void validateNumberInRange(int lottoNumber) {
        if (lottoNumber < LottoNumbers.MIN_LOTTO_NUMBER.getNumber()
                || lottoNumber > LottoNumbers.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45까지의 숫자만 입력할 수 있습니다.");
        }
    }

    public void validatePurchasePriceIsNumber(String purchasePrice){
        if (!Pattern.matches(NUMBER, purchasePrice)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public void validateInputDataIsNumber(String inputData) {
        if (!Pattern.matches(NUMBER, inputData)) {
            throw new IllegalArgumentException("로또 번호는 숫자만 입력 가능합니다.");
        }
    }

    public void validateDuplicateNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호가 당첨번호에 속해있습니다.");
        }
    }
}
