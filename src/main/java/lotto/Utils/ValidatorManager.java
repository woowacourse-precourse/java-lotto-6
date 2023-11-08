package lotto.Utils;

import java.util.List;
import java.util.Set;

public class ValidatorManager {
    public void validateLottoNumbersManager(String input, Set<Integer> numbersSet) {
        Validator.validateNotEmpty(input);
        Validator.validateNumberCount(input);
        String[] numbersStr = input.split(",");
        Validator.validateNumbersRange(numbersStr);
        for (String numberStr : numbersStr) {
            int number = Integer.parseInt(numberStr.trim());
            Validator.validateNumberRange(number);
            Validator.validateLottoNumbersDuplicate(number, numbersSet);
        }
    }

    // 보너스 번호 입력받았을 때 검증하는 메서드
    public void validateBonusNumberManager(String input, List<Integer> lottoNumbers) {
        Validator.validateNotEmpty(input);
        Validator.validateBonusNumberFormat(input);
        int bonusNumber = Integer.parseInt(input.trim());
        Validator.validateNumberRange(bonusNumber);
        Validator.validateBonusNumberDuplicate(bonusNumber, lottoNumbers);
    }

    // 돈을 입력받았을 때 검증하는 메서드
    public void validateMoneyManager(String input) {
        Validator.validateNotEmpty(input);
        int money = Integer.parseInt(input.trim());
        Validator.moneyValidator(money);
    }
}
