package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

/**
 * 당첨 번호와 보너스 번호 담고 있는 클래스
 */
public class LottoWinning {
    private Lotto winningNum;
    private LottoNumber bonusNum;

    public LottoWinning() {
    }

    public LottoWinning(List<Integer> numbers, int bonusNum) {
        validateDuplicate(numbers, bonusNum);
        this.winningNum = new Lotto(numbers);
        this.bonusNum = new LottoNumber(bonusNum);
    }

    public Lotto getWinningNum() {
        return winningNum;
    }

    public LottoNumber getBonusNum() {
        return bonusNum;
    }

    // 보너스 숫자가 중복된 값이면 예외 발생
    private void validateDuplicate(List<Integer> winningNum, int bonusNum) {
        if (winningNum.stream().anyMatch(s -> s == bonusNum)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUM.getMessage());
        }
    }
}
