package lotto.service;

import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.LottoNumbers;
import lotto.domain.Unit;

public class NumberValidator {

    private static final String NUMBER = "^[0-9]+$";

    public void validateInputDataIsNumber(String inputData) {
        if (!Pattern.matches(NUMBER, inputData)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.");
        }
    }

    public void validateInputDataLengthIsSix(String[] inputData){
        if(inputData.length != LottoNumbers.LOTTO_SIZE.getNumber()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
        }
    }

    public void validateDuplicateNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호가 당첨번호에 속해있습니다.");
        }
    }
    public void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % Unit.PURCHASE_UNIT.getValue() != Unit.ZERO.getValue()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
