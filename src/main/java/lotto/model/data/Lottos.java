package lotto.model.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또들을 가지고 있다.
 * 로또를 구입하고, 구입한 로또를 확인하고, 정답 번호와 비교하는 기능을 제공한다.
 */
public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    /**
     * 주어진 번호를 가진 새 로또를 추가한다.
     *
     * @param lotto 새 로또의 번호
     */
    public void buyLotto(List<Integer> lotto) {
        lottos.add(new Lotto(lotto));
    }

    /**
     * 구입한 모든 로또들을 수정할 수 없는 리스트로 반환한다.
     *
     * @return 수정 불가능 한 모든 로또들
     */
    public List<Lotto> purchasedLotto() {
        return Collections.unmodifiableList(lottos);
    }

    /**
     * 모든 로또들을 정답 번호와 비교한다.
     *
     * @param answerNumbers 저장된 로또 번호들과 비교할 정답 번호
     * @return 당첨 내역
     */
    public WinningStatus compareWithAnswerNumbers(AnswerNumbers answerNumbers) {
        WinningStatus winningStatus = new WinningStatus();

        for (Lotto lotto : lottos) {
            int countOfMatchedWinningNumber = lotto.compareLottoAndWinningNumbers(
                    answerNumbers.getWinningNumbers());
            int countOfMatchedBonusNumber = lotto.compareLottoAndBonusNumber(answerNumbers.getBonusNumber());

            winningStatus.recordWinning(countOfMatchedWinningNumber, countOfMatchedBonusNumber);
        }

        return winningStatus;
    }
}
