package lotto.domain;

import lotto.util.InputHelper;

import java.util.List;

/**
 * 도메인에 관련된 상태를 관리하는 클래스.
 */
public class LottoStateManager {
    private WinningNumbers winningNumbers;
    private int numOfLotto;
    private List<Lotto> generatedLotto;

    private LottoStateManager() {
    }

    private static class Singleton {
        private static final LottoStateManager FLOW_MANAGER = new LottoStateManager();
    }

    /**
     * 싱글톤 패턴에 따라 LottoStateManager의 인스턴스를 반환한다.
     * @return LottoStateManager 싱글톤 인스턴스.
     */
    public static LottoStateManager getInstance() {
        return Singleton.FLOW_MANAGER;
    }

    /**
     * 구입할 로또의 개수를 입력받는다.
     */
    public void inputNumOfLotto() {
        this.numOfLotto = InputHelper.numOfLottoToBuy();
    }

    /**
     * 입력받은 로또의 개수만큼 로또를 생성한다.
     * 생성된 로또는 LottoStateManager에 저장된다.
     * @return 생성된 로또. 리스트의 길이는 입력받은 로또 발행 수와 같다.
     */
    public List<Lotto> generateLotto() {
        List<Lotto> generated = LottoGenerator.generate(this.numOfLotto);
        this.generatedLotto = generated;
        return generated;
    }

    /**
     * 당첨 번호를 입력받는다.
     */
    public void inputWinningNumbers() {
        this.winningNumbers = InputHelper.winningNumbers();
    }

    /**
     * 입력받은 당첨 번호와 발행된 로또로부터 LottoManager를 생성한다.
     * @return LottoManager 인스턴스.
     */
    public LottoManager generateLottoManager() {
        return new LottoManager(this.winningNumbers, this.generatedLotto);
    }

    /**
     * lottoManager에서 처리한 결과를 반환한다.
     * @param lottoManager generateLottoManager로 생성된 LottoManager 인스턴스.
     * @return lottoManager가 처리한 결과.
     */
    public Result getResult(LottoManager lottoManager) {
        return lottoManager.processLotto();
    }
}
