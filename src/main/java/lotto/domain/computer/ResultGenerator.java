package lotto.domain.computer;

import static lotto.constant.ExceptionMessage.ENTER_CORRECT_RANGE_NUMBER;
import static lotto.constant.ExceptionMessage.ENTER_NOT_DUPLICATION_NUMBER;
import static lotto.constant.LottoNumber.*;

import lotto.constant.LottoNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class ResultGenerator {

    private Lotto winningLotto;
    private int bonusNumber;

    public Result createResult(Lottos lottos) {
        Result result = new Result(getUserMoney(lottos));
        lottos.lottoList().forEach(lotto ->
                setRank(result, lotto, winningLotto.compare(lotto))
        );

        return result;
    }

    private int getUserMoney(Lottos lottos) {
        return lottos.lottoList().size() * LOTTO_PRICE.getNumber();
    }

    private void setRank(Result result, Lotto lotto, int compare) {
        if (compare == 3) {
            result.plusFifth();
        }
        if (compare == 4) {
            result.plusForth();
        }
        if (compare == 5 && !lotto.getNumbers().contains(bonusNumber)) {
            result.plusThird();
        }
        if (compare == 5 && lotto.getNumbers().contains(bonusNumber)) {
            result.plusSecond();
        }
        if (compare == 6) {
            result.plusFirst();
        }
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        checkRange(bonusNumber);
        checkDuplication(bonusNumber);
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER.getNumber() || bonusNumber > MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ENTER_CORRECT_RANGE_NUMBER.getMessage());
        }
    }

    private void checkDuplication(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ENTER_NOT_DUPLICATION_NUMBER.getMessage());
        }
    }
}
