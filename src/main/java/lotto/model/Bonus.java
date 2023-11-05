package lotto.model;

import java.util.List;
import java.util.regex.Pattern;

public class Bonus {
    private int number;
    private Lotto lotto;
    private static final Pattern BONUS_REGEX = Pattern.compile("^[0-9]+$");


    public Bonus(Lotto lotto, String inputBonusNumber) {
        this.lotto = lotto;
        validate(inputBonusNumber);
        this.number = stringToInteger(inputBonusNumber);
    }

    public void validate(String inputBonusNumber) {
        validateNumeric(inputBonusNumber);
        int bonusNumber = stringToInteger(inputBonusNumber);
        validateDuplicate(lotto.getNumbers(), bonusNumber);
        validateRange(bonusNumber);
    }

    public int stringToInteger(String inputBonusNumber) {
        return Integer.parseInt(inputBonusNumber);
    }

    public void validateNumeric(String inputBonusNumber) {
        if (!BONUS_REGEX.matcher(inputBonusNumber).matches()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수만 입력 가능합니다.");
        }
    }

    public void validateDuplicate(List<Integer> winningLottoNumbers, int bonusNumber) {
        if(winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public void validateRange(int inputBonusNumber) {
        if(inputBonusNumber < 1 || inputBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이만 입력 가능합니다.");
        }
    }

    public int getBonusNumber() {
        return number;
    }

}
