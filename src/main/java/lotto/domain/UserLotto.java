package lotto.domain;

import java.util.List;

public class UserLotto {

    private Lotto mainLottoNumber;
    private BonusLotto bonusNumber; //유효검사

    public static final String ERROR_DUPLICATE_BONUS = "보너스 번호가 6자리 로또 번호와 중복되었어요.";

    public UserLotto(Lotto mainLottoNumber, BonusLotto bonusNumber) {
        validate(mainLottoNumber, bonusNumber);
        this.mainLottoNumber = mainLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getMainLottoNumber() {
        return mainLottoNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    private void validate(Lotto mainLottoNumber, BonusLotto bonusNumber) {
        List<Integer> mainLotto = mainLottoNumber.getNumbers();
        if (mainLotto.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
        }
    }
}
