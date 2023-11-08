package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.RandomLottoNumberGenerator;
import lotto.view.OutputView;

/**
 * Lotto 객체들을 관리하는 클래스
 */
public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    /**
     * 발행할 로또 개수를 받아 로또 생성
     * @param count 발행할 로또 개수
     */
    public Lottos(Integer count) {
        for (int i = 0; i < count; i++) {
            addLotto();
        }
    }

    private void addLotto() {
        Lotto newLotto = makeLotto();

        lottos.add(newLotto);
    }

    private Lotto makeLotto() {
        List<Integer> numbers = RandomLottoNumberGenerator.makeNumber();

        return new Lotto(numbers);
    }

    /**
     * 구입한 로또 개수와 로또 목록을 출력하는 함수
     */
    public void print() {
        OutputView.printTicketCount(lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    /**
     * 당첨 목록을 반환하는 함수
     */
    public LottoResult checkResult(WinningNumber winningNumber) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos) {
            int count = countMatchWinningNumber(lotto, winningNumber);
            boolean bonusMatch = lotto.isContainNumber(winningNumber.bonusNumber());
            result.update(count, bonusMatch);
        }

        return result;
    }

    private Integer countMatchWinningNumber(Lotto lotto, WinningNumber winningNumber) {
        int count = 0;
        for (Integer number : winningNumber.winningNumbers()) {
            if (lotto.isContainNumber(number)) {
                count++;
            }
        }
        return count;
    }
}
