package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.WinLotto;
import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.player.Player;
import lotto.domain.player.Profit;
import lotto.domain.service.LottoPurchaseService;
import lotto.domain.service.LottoResultsService;
import lotto.util.ModelAndViewConverter;
import lotto.util.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final ModelAndViewConverter modelAndViewConverter;
    private final InputView inputView;

    public LottoController(ModelAndViewConverter modelAndViewConverter, InputView inputView, OutputView outputView) {
        this.modelAndViewConverter = modelAndViewConverter;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void doLottoGame() {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(new LottoBundle());
        LottoResultsService lottoResultsService = new LottoResultsService(new LottoResultsRepository());

        Player player = makePlayer();
        player = lottoPurchaseService.purchaseLotto(player, RandomLottoGenerator::generateRandomLotto);

        printPurchaseLotto(lottoPurchaseService);

        WinLotto winLotto = makeWinLotto();

        checkAndPrintWinning(lottoPurchaseService, lottoResultsService, winLotto);

        checkAndPrintProfit(player, lottoResultsService);
    }

    private Player makePlayer() {
        return repeat(() -> new Player(inputView.inputPurchaseMoney()), modelAndViewConverter);
    }

    private void printPurchaseLotto(LottoPurchaseService lottoPurchaseService) {
        modelAndViewConverter.addComponent(lottoPurchaseService.makeLottoBundleDto());
        outputView.printTotalNumberOfLotto(modelAndViewConverter);
        outputView.printTotalLotto(modelAndViewConverter);
    }

    private WinLotto makeWinLotto() {
        List<Integer> winLottoNumber = repeat(inputView::inputWinLottoNumber, modelAndViewConverter);
        Integer winBonusNumber = repeat(inputView::inputBonusNumber, modelAndViewConverter);
        return repeat(() -> new WinLotto(winLottoNumber, winBonusNumber), modelAndViewConverter);
    }

    private void checkAndPrintWinning(LottoPurchaseService lottoPurchaseService,
                                      LottoResultsService lottoResultsService,
                                      WinLotto winLotto) {
        lottoResultsService.updateLottoResultRepository(lottoPurchaseService, winLotto);
        modelAndViewConverter.addComponent(lottoResultsService.makeLottoResultsDto());
        outputView.printLottoResultsData(modelAndViewConverter);
    }

    private void checkAndPrintProfit(Player player, LottoResultsService lottoResultsService) {
        Profit profit = player.getProfit(lottoResultsService.makeLottoResultsDto());
        modelAndViewConverter.addComponent(profit);
        outputView.printProfit(modelAndViewConverter);
    }

    private <T> T repeat(Supplier<T> something, ModelAndViewConverter modelAndViewConverter) {
        try {
            return something.get();
        } catch (IllegalArgumentException e) {
            modelAndViewConverter.addComponent(e);
            outputView.printError(modelAndViewConverter);
            return repeat(something, modelAndViewConverter);
        }
    }
}
