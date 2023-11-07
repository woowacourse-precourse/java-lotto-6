package lotto.domain.lottos;

import java.util.List;

public class UserLotto {
    public static final String ERROR_DUPLICATE_BONUS = "보너스 번호가 6자리 로또 번호와 중복되었어요.";
    private Lotto mainLottoNumber;
    private BonusLotto bonusNumber;

    public UserLotto(Lotto mainLottoNumber, BonusLotto bonusNumber) {
        validate(mainLottoNumber, bonusNumber);
        this.mainLottoNumber = mainLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getMainLottoNumber() {
        return mainLottoNumber;
    }

    public BonusLotto getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto mainLottoNumber, BonusLotto bonusNumber) {
        List<Integer> mainLotto = mainLottoNumber.getNumbers();
        if (mainLotto.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
        }
    }

}
