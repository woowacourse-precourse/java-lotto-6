package lotto.Service;

import static lotto.config.LottoConfig.LOTTO_AMOUNT;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.OutputView;

/**
 * 로또 진행 과정에 필요한 작업을 진행하는 클래스
 */
public class LottoService {
    Integer amount;

    /**
     * 구매 금액을 받아 Lotto 객체를 반환
     * @param amount 로또 구입 금액
     * @return 구입 개수만큼 생성된 Lotto 객체들
     */
    public Lottos getLottos(Integer amount) {
        Integer lottoCount = amount / LOTTO_AMOUNT.getValue();
        this.amount = amount;

        return new Lottos(lottoCount);
    }

    /**
     * 구입한 로또 정보를 출력
     * @param lottos 구입한 로또들
     */
    public void printLottos(Lottos lottos) {
        lottos.print();
    }

    /**
     * 로또 결과를 반환
     * @param lottos 구입한 로또 목록
     * @param winningNumber 당첨 번호
     * @return 당첨 결과
     */
    public LottoResult getResult(Lottos lottos, WinningNumber winningNumber) {
        return lottos.checkResult(winningNumber);
    }

    /**
     * 당첨 결과 및 통계를 출력
     * @param result 당첨 결과
     */
    public void printStatistics(LottoResult result) {
        long totalPrize = result.getTotalPrize();
        double yield = roundSecondPlace(totalPrize / (double) amount * 100);

        result.print();
        OutputView.printStatistics(yield);
    }

    private double roundSecondPlace(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
