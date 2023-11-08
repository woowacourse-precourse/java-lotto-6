package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import lotto.domain.Member;
import lotto.domain.WinningNumber;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class GameController {

    private final LottoInputView lottoInputView = new LottoInputView();

    public void start() {
        long inputMoney = lottoInputView.inputUserMoney();
        List<Lotto> lottos = purchaseLotto(inputMoney);

        Member member = new Member(inputMoney, lottos);
        LottoOutputView.showPurchasedLotto(member);

        WinningNumber winnerNumber = retrieveWinningNumber();
        List<LottoRank> ranks = determineLottoRanks(member, winnerNumber);

        LottoOutputView.showGameResult(member, ranks);
    }

    private List<Lotto> purchaseLotto(long money) {
        LottoGenerator lottoGenerator = new LottoGenerator(money);
        return lottoGenerator.generateLottos();
    }

    private WinningNumber retrieveWinningNumber() {
        Lotto lotto = new Lotto(lottoInputView.inputWinningNumber());
        int bonusNumber = lottoInputView.inputBonusNumber();

        return new WinningNumber(lotto, bonusNumber);
    }

    private List<LottoRank> determineLottoRanks(Member member, WinningNumber winningNumber) {
        return member.getLottos().stream()
                .map(lotto -> LottoRank.calculate(lotto, winningNumber))
                .toList();
    }

}
