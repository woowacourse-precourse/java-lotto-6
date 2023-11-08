package lotto.engine;

import static lotto.engine.LottoSystemConstant.LOTTO_PRICE;

import java.util.List;
import lotto.Lotto;
import lotto.engine.LottoSystemConstant.TextMessage.Pattern;
import lotto.engine.dto.WinningNumber;
import lotto.view.LottoGameViewer;

public final class LottoGame {
    private final LottoGameViewer viewer;
    private final LottoFactory lottoFactory;

    public LottoGame(LottoGameViewer viewer, LottoFactory lottoFactory) {
        this.viewer = viewer;
        this.lottoFactory = lottoFactory;
    }

    public void start() {
        int money = viewer.interactForBuyLotto();
        int quantity = money / LOTTO_PRICE.value();
        viewer.printNewLine();

        viewer.println(() -> String.format(Pattern.BUY_RESULT.getMessage(), quantity));
        List<Lotto> lottos = lottoFactory.issueLotto(quantity);
        String issuedTotalLotto = lottoFactory.showTotalLotto(lottos);
        viewer.println(() -> issuedTotalLotto);
        viewer.printNewLine();

        List<Integer> numbers = viewer.interactForWinningNumber();
        viewer.printNewLine();

        int bonus = viewer.interactForBonusNumber();
        viewer.printNewLine();

        WinningNumber winningNumber = new WinningNumber(numbers, bonus);
        //todo : 당첨 통계 보여주기
    }

}
