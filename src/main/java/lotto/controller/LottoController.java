package lotto.controller;

import lotto.Lotto;
import lotto.domain.Member;
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
        Member member = generateLottoMember(money);
        OutputView.purchaseResult(member);

        Lotto winnerLotto = new Lotto(InputView.getWinningNumberInput());
        int bonusNumber = InputView.getBonusNumberInput();
        WinningNumber winningNumber = new WinningNumber(winnerLotto, bonusNumber);

        // TODO: 멤버의 구매 로또 리스트를 넘겨받아 추첨하는 로직 추가

    }

    private Member generateLottoMember(final int money) {
        List<Lotto> purchasedLottos = lottoService.purchase(money);
        return new Member(money, purchasedLottos);
    }
}
