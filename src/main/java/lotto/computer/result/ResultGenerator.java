package lotto.computer.result;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

public class ResultGenerator {

    private Lotto winningLotto;
    private int bonusNumber;

    public Result createResult(Lottos lottos, int money) {
        Result result = new Result(money);
        lottos.lottoList().forEach(lotto ->
                setRank(result, lotto, winningLotto.compare(lotto))
        );

        return result;
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
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("1~45 사이의 숫자를 입력해 주세요.");
        }
    }

    private void checkDuplication(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복되지 않는 숫자를 입력해 주세요.");
        }
    }
}
