package lotto.model;

import java.util.List;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        validateWinningLottoRange(winningLotto);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLottoRange(List<Integer> winningLotto) {
        for (Integer lottoNumber : winningLotto) {
            if (!isValidRange(lottoNumber)) {
                throw new IllegalArgumentException("당첨 번호는 1~45 사이만 입력 가능합니다.");
            }
        }
    }

    private boolean isValidRange(int number) {
        return MIN_RANGE <= number && number <= MAX_RANGE;
    }
}