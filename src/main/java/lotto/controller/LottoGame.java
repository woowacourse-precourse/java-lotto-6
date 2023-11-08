package lotto.controller;


import java.math.BigDecimal;
import java.util.EnumMap;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.enums.ConstantsMessage;
import lotto.enums.LottoPrize;
import lotto.services.EarningRateCalculator;
import lotto.services.LottoNumberComparator;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final OutputView outputView;
    private final InputController inputController;
    private Lottos lottos;

    public LottoGame() {
        this.outputView = new OutputView();
        this.inputController = new InputController(new InputView(), outputView);
    }

    public void play() {
        LottoPurchase lottoPurchase = inputController.calculateLottoCount();

        int purchaseCount = lottoPurchase.calculateLottoCount();
        outputView.print(String.format(ConstantsMessage.CONFIRM_PURCHASE_COUNT.message, purchaseCount));

        this.lottos = new Lottos(inputController.purchaseLottos(purchaseCount));
        outputView.printLottoNumbers(lottos.getPurchaseLottos());

        WinningLotto winningLotto = inputController.generateWinningLotto();
        EnumMap<LottoPrize, Integer> prizes = calculatePrizes(winningLotto);

        printLottoGameResult(prizes, lottoPurchase.getMoney());
    }

    public EnumMap<LottoPrize, Integer> calculatePrizes(WinningLotto winningLotto) {
        LottoNumberComparator comparator = new LottoNumberComparator(lottos.getPurchaseLottos(), winningLotto);
        comparator.calculatePrizes();
        return comparator.getPrizeCount();
    }

    private void printLottoGameResult(EnumMap<LottoPrize, Integer> prizes, int purchaseCount) {
        BigDecimal earningRate = EarningRateCalculator.calculate(prizes, purchaseCount);
        String result = LottoGameResult.generatePrizeResults(prizes);
        outputView.printPrizeResult(result);
        outputView.print(
                String.format(ConstantsMessage.PROFIT_RATE_MESSAGE.message,
                        Parser.formatProfitCurrency(earningRate)));
    }
}
