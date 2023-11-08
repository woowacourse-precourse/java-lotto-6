package lotto.model.data;

import java.util.Collections;
import java.util.List;

/**
 * 정답 번호 중 당첨 번호를 캡슐화한다.
 */
public class WinningNumbers {
    private List<Integer> winningNumbers;

    /**
     * 주어진 숫자들로 이루어진 당첨 번호를 생성한다.
     *
     * @param winningNumbers 새 당첨 번호
     */
    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    /**
     * winningNumbers의 무결성을 위하여 수정할 수 없는 당첨 번호를 반환한다.
     *
     * @return 수정할 수 없는 당첨 번호
     */
    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
