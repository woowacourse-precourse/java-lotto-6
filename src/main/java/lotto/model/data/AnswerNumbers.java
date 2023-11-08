package lotto.model.data;

import java.util.Collections;
import java.util.List;
import lotto.model.record.BonusNumber;

/**
 * 정답 번호인 당첨 번호와 보너스 번호를 캡슐화한다.
 */
public class AnswerNumbers {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    /**
     * 새로운 AnswerNumbers 인스턴스를 생성한다.
     *
     * @param winningNumbers 로또 게임의 당첨 번호
     * @param bonusNumber 로또 게임의 보너스 번호
     */
    public AnswerNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 당첨 번호를 반환한다.
     *
     * 당첨 번호의 무결성을 보장하기 위하여 unmodifiable 리스트를 반환한다.
     *
     * @return 당첨 번호를 나타내는 unmodifiable 리스트
     */
    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers.getWinningNumbers());
    }

    /**
     * 보너스 번호를 반환한다.
     * 보너스 번호의 무결성을 보장하기 위하여 Record를 반환한다.
     *
     * @return 보너스 번호를 나타내는 Record
     */
    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
