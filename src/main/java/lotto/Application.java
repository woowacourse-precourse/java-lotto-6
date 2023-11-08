package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoPlayer;
import lotto.domain.Winning;
import lotto.enums.OutputMessageEnum;
import lotto.utils.Generator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    static final int LOTTO_START = 1;
    static final int LOTTO_END = 45;
    static final int LOTTO_COUNT = 6;
    static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGameResult lottoGameResult = new LottoGameResult();

        int purchasePrice = inputView.inputPurchasePrice();
        System.out.println();

        int purchaseAmount = purchasePrice / LOTTO_PRICE;
        outputView.printPurchaseAmount(purchaseAmount);
        List<Lotto> lottos = Generator.generateLottos(LOTTO_START, LOTTO_END, LOTTO_COUNT, purchaseAmount);
        for (Lotto lotto : lottos) {
            outputView.printLotto(lotto);
        }
        System.out.println();

        LottoPlayer lottoPlayer = new LottoPlayer(purchasePrice, lottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers(LOTTO_COUNT);
        int bonusNumber = inputView.inputBonusNumber();
        Winning winning = new Winning(winningNumbers, bonusNumber);

        lottoGameResult.calculateLottoRanks(lottos, winning);

        System.out.println();

        System.out.println(OutputMessageEnum.OUTPUT_RESULT_START_MESSAGE.getMessage());
        System.out.println(OutputMessageEnum.OUTPUT_LINE.getMessage());

        outputView.printLottoGameResult(lottoPlayer, lottoGameResult);

    }
}
