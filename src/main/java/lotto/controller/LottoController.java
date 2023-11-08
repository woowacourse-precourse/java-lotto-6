package lotto.controller;

import lotto.domain.Cost;
import lotto.domain.DrawnNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.view.BonusRequestVIew;
import lotto.view.CostRequestView;
import lotto.view.LottoResultView;
import lotto.view.WinningRequestView;
import lotto.view.WinningResultView;

public class LottoController {
    public void run() {
        Cost cost = CostRequestView.request();
        Lottos lottos = issue(cost.getCount());
        DrawnNumbers drawnNumbers = draw();
        conclude(lottos, drawnNumbers, cost);
    }

    /**
     * 요청된 로또 개수만큼 로또를 발행하는 메서드
     *
     * @param count 로또의 개수
     * @return 발행된 로또들의 정보를 담은 일급 컬렉션
     */
    private Lottos issue(final int count) {
        Lottos lottos = Lottos.from(count);
        LottoResultView.print(lottos);
        return lottos;
    }

    /**
     * 당첨 번호와 보너스 번호를 추첨하는 메서드
     *
     * @return 당첨 번호와 보너스 번호를 저장한 객체
     */
    private DrawnNumbers draw() {
        return DrawnNumbers.from(WinningRequestView.request(), BonusRequestVIew.request());
    }

    /**
     * 발행된 로또와 추첨한 번호들을 통해 당첨 내역을 계산하고, 총 당첨 금액과 로또 구매 비용을 통해 수익률을 계산
     *
     * @param lottos       발행된 로또
     * @param drawnNumbers 당첨 번호와 보너스 번호
     * @param cost         로또 구매 비용
     */
    private void conclude(final Lottos lottos, final DrawnNumbers drawnNumbers, final Cost cost) {
        WinningResult winningResult = WinningResult.of(lottos, drawnNumbers);
        WinningResultView.print(winningResult, cost);
    }
}
