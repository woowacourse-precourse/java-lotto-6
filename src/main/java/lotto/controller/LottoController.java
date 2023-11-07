package lotto.controller;

import static lotto.view.constant.InputMessage.GET_BONUS_NUMBER_MESSAGE;
import static lotto.view.constant.InputMessage.GET_PURCHASE_AMOUNT_MESSAGE;
import static lotto.view.constant.InputMessage.GET_WINNING_NUMBERS_MESSAGE;
import static lotto.view.constant.OutputMessage.NEWLINE;

import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.service.LottoPrizeService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningNumbersService;
import lotto.service.LottosService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottosService lottosService;
    private final LottoWinningNumbersService winningNumbersService;
    private final LottoPrizeService lottoPrizeService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoPurchaseService = new LottoPurchaseService();
        this.lottosService = new LottosService();
        this.winningNumbersService = new LottoWinningNumbersService();
        this.lottoPrizeService = new LottoPrizeService();
    }

    public void play() {
        String purchaseAmount = getPurchaseAmount();
        LottoPurchase lottoPurchase = lottoPurchaseService.createLottoPurchase(purchaseAmount);
        Lottos lottos = lottosService.createLottos(lottoPurchase);
        printLottoNumbers(lottos);

        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber(winningNumbers);
        LottoWinningNumbers lottoWinningNumbers = winningNumbersService.createLottoWinningNumbers(winningNumbers,
                bonusNumber);

        LottoPrize lottoPrize = lottoPrizeService.createLottoPrize(lottos, lottoWinningNumbers);
    }

    public String getPurchaseAmount() {
        OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return inputView.readAmountInput();
    }

    public String getWinningNumbers() {
        OutputView.printMessage(GET_WINNING_NUMBERS_MESSAGE.getMessage());
        return inputView.readWinningNumbers();
    }

    public String getBonusNumber(String winningNumbers) {
        OutputView.printMessage(NEWLINE.getMessage() + GET_BONUS_NUMBER_MESSAGE.getMessage());
        return inputView.readBonusNumber(winningNumbers);
    }

    public void printLottoNumbers(Lottos lottos) {
        outputView.printLottoNumbers(lottos);
    }
}
