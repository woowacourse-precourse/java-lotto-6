package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        // 구입 금액 입력 받기
        int purchaseAmount = InputView.inputPurchaseAmount();

        // 로또 티켓 구매
        List<LottoTicket> lottoTickets = lottoMachine.purchaseTickets(purchaseAmount);
        OutputView.showTickets(lottoTickets);

        // 당첨 번호 입력 받기
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        // 당첨 결과 계산
        LottoResult lottoResult = lottoMachine.calculateResults(lottoTickets, winningNumbers, bonusNumber);

        // 결과 출력
        Map<LottoRank, Integer> results = lottoResult.getResults();
        double profitRatio = lottoResult.calculateProfitRatio();
        OutputView.showResults(results, profitRatio);
    }
}
