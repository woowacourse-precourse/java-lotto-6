package lotto.controller;

import lotto.Lotto;
import lotto.domain.Member;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(final LottoService lottoService) {
        this.lottoService = lottoService;
    }
    public void play(){
        int money = InputView.getPurchasePriceInput();
        List<Lotto> purchasedLottos = lottoService.purchase(money);
        Member member = generatedMember(money, purchasedLottos);

        OutputView.purchaseResult(member);

        List<Integer> winningNumberInput = InputView.getWinningNumberInput();
        Lotto winnerLotto = new Lotto(winningNumberInput);
        int bonusNumber = InputView.getBonusNumberInput(winningNumberInput);
        WinningNumber winningNumber = new WinningNumber(winnerLotto, bonusNumber);

        List<Rank> awardsResult = lottoService.awards(member, winningNumber);
        OutputView.gameResult(awardsResult,member);
    }

    private static Member generatedMember(final int money, final List<Lotto> purchasedLottos) {
        return new Member(money, purchasedLottos);
    }
}
