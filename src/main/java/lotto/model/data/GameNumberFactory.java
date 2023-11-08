package lotto.model.data;

import java.util.Comparator;
import java.util.List;
import lotto.model.generator.LottoNumberGenerator;
import lotto.model.record.BonusNumber;

/**
 * 로또 번호와 정답 번호(당첨 번호, 보너스)를 포함하는 게임 번호를 생성하는 책임이 있다.
 * 로또 번호는 자동 혹은 추첨으로 생성하고 로또 번호와 정답 번호를 저장하며, 생성된 로또 번호를 기준으로 정답 번호와 비교하는 기능을 제공한다.
 */
public class GameNumberFactory {
    private final Lottos lottos = new Lottos();
    private AnswerNumbers answerNumber;

    /**
     * 자동 혹은 수동을 이용하여 여러 개의 로또 번호를 생성한다.
     *
     * @param amountOfLotto 생성할 로또의 개수
     * @param lottoNumberGenerator 로또 번호를 생성할 방식
     * @param order 로또 번호를 저장할 때 정렬 기준
     * @return 생성된 로또의 리스트
     */
    public List<Lotto> quickPickOrSlip(Integer amountOfLotto, LottoNumberGenerator lottoNumberGenerator,
                                       Comparator<Integer> order) {
        for (int idx = 0; idx < amountOfLotto; idx++) {
            lottos.buyLotto(lottoNumberGenerator.drawLots(order));
        }

        return lottos.purchasedLotto();
    }

    /**
     * 당첨 번호와 보너스 번호를 저장한다.
     *
     * @param winningNumbers 당첨 번호
     * @param bonusNumber 보너스 번호
     */
    public void saveAnswerNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        answerNumber = new AnswerNumbers(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber));
    }

    /**
     * 저장된 로또 번호를 이용하여 당첨 번호와 비교해 당첨 내역을 계산한다.
     *
     * @return 비교의 결과로 얻을 수 있는 당첨 내역
     */
    public WinningStatus calculateWinningStatus() {
        return lottos.compareWithAnswerNumbers(answerNumber);
    }
}
