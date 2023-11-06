package lotto.domain.userpick;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateSeparatedLottoNumbers(String[] separatedLottoNumbers) {
        if (separatedLottoNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)를 기준으로 6개의 당첨 번호를 입력해주세요");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String separatedLottoNumber : separatedLottoNumbers) {
            int parsedLottoNumber = Integer.parseInt(separatedLottoNumber);

            if (uniqueNumbers.contains(parsedLottoNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
            }

            validateRange(parsedLottoNumber);
            uniqueNumbers.add(parsedLottoNumber);
        }
    }


    public void validateBonusNumber(String bonusNumber, List<Integer> parsedLottoNumbers) {
        int bonus = Integer.parseInt(bonusNumber);
        validateRange(bonus);

        if (parsedLottoNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹칠 수 없습니다.");
        }
    }

    public void validateRange(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 수를 입력해주세요.");
        }
    }
}
