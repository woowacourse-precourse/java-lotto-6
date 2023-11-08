package Model;

import static Model.RandomLottoGenerator.BIGGEST_LOTTO_NUMBER;
import static Model.RandomLottoGenerator.SMALLEST_LOTTO_NUMBER;

import java.util.List;
import lotto.Lotto;

public class LottoAnswerSheet {
    public Lotto generateWinningLotto(List<Integer> winningLottoNumbers) {
        return new Lotto(winningLottoNumbers);
    }

    public int generateBonusNumber(Lotto winningLotto, int bonusNumber) {
        inRangeValidate(bonusNumber);
        if (winningLotto.isLottoNumberDuplicate(bonusNumber)) {
            throw new IllegalArgumentException("당첨 로또 번호와 보너스 로또 번호는 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    private void inRangeValidate(int number) {
        if (number < SMALLEST_LOTTO_NUMBER || number > BIGGEST_LOTTO_NUMBER) {
            throw new IllegalArgumentException("당첨 번호는 1~45의 숫자여야 합니다.");
        }
    }
}
