package lotto.model;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        validateWinningLottoRange(winningLotto);
        validateWinningLottoUnique(winningLotto);
        validateWinningLottoLength(winningLotto);
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

    private void validateWinningLottoUnique(List<Integer> winningLotto) {
        HashSet<Integer> unique = new HashSet<>(winningLotto);
        if (unique.size() != winningLotto.size()) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    private void validateWinningLottoLength(List<Integer> winningLotto) {
        if (winningLotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호 6개를 입력해야 합니다.");
        }
    }

    private boolean isValidRange(int number) {
        return MIN_RANGE <= number && number <= MAX_RANGE;
    }
}