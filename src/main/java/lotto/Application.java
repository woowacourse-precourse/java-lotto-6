package lotto;

import lotto.domain.LottoDraw;
import lotto.domain.LottoResult;
import lotto.ui.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        LottoDraw lottoDraw = new LottoDraw(input.purchasePrice());
        lottoDraw.configureLottoNumbers();
        lottoDraw.printPurchaseHistory();
        input.winningNumbers();
        input.BonusNumber();
        LottoResult lottoResult = new LottoResult(lottoDraw.getLottos());
        lottoResult.configurePrizeCount(input.getWinningNumbers());
        lottoResult.printWinningHistory();
    }
}
