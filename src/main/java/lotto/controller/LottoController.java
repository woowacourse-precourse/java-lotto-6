package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoAwards;
import lotto.domain.Member;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
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

        List<Rank> awardsResult = awards(member, winningNumber);
        OutputView.gameResult(awardsResult,member);

    }

    private List<Rank> awards(final Member member, final WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : member.getLottos()) {
            Rank rank = LottoAwards.awards(lotto, winningNumber);
            ranks.add(rank);
        }
        return ranks;
    }

    private Member generateLottoMember(final int money) {
        List<Lotto> purchasedLottos = lottoService.purchase(money);
        return new Member(money, purchasedLottos);
    }
}
