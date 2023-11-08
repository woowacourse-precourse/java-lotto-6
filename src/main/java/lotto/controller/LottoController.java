package lotto.controller;

import static lotto.util.Introduction.INPUT_AMOUNT_OF_LOTTO;
import static lotto.util.Introduction.INPUT_BONUS_NUMBER;
import static lotto.util.Introduction.INPUT_WINNING_NUMBERS;
import static lotto.util.Introduction.SEPARATOR;
import static lotto.util.Introduction.WINNING_STATISTICS;
import static lotto.util.PrizeDetails.FIFTH_PRIZE;
import static lotto.util.PrizeDetails.FIRST_PRIZE;
import static lotto.util.PrizeDetails.FOURTH_PRIZE;
import static lotto.util.PrizeDetails.SECOND_PRIZE;
import static lotto.util.PrizeDetails.THIRD_PRIZE;

import java.util.List;
import lotto.model.data.Lotto;
import lotto.model.data.WinningPortfolio;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService lottoService;

    private LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        lottoService = new LottoService();
    }

    public static LottoController of(InputView inputView, OutputView outputView) {
        return new LottoController(inputView, outputView);
    }

    public void lottoStore() {
        boolean successToBuyLotto = false;

        do {
            try {
                Integer amountOfLotto = getAmountOfLotto();
                createLottos(amountOfLotto);

                successToBuyLotto = true;
            } catch (IllegalArgumentException e) {
                outputView.printIntroduction(e.getMessage());
            }
        } while (!successToBuyLotto);
    }

    private Integer getAmountOfLotto() {
        outputView.printIntroduction(INPUT_AMOUNT_OF_LOTTO.getIntroduction());
        Integer amountOfInvestment = lottoService.convertAmountOfInvestment(inputView.inputConstant());
        return lottoService.makeRecipe(amountOfInvestment);
    }

    private void createLottos(Integer amountOfLotto) {
        List<Lotto> purchasedLottos = lottoService.generateLottos(amountOfLotto);
        outputView.printResultOfBuy(amountOfLotto);
        outputView.printLottos(purchasedLottos);
    }

    public void answerNumbersInput() {
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber(winningNumbers);

        lottoService.createWinningNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        boolean successToCreateWinningNumbers = false;

        do {
            try {
                outputView.printIntroduction(INPUT_WINNING_NUMBERS.getIntroduction());
                return lottoService.convertWinningNumbers(inputView.inputList());
            } catch (IllegalArgumentException e) {
                outputView.printIntroduction(e.getMessage());
            }
        } while (!successToCreateWinningNumbers);

        return null;
    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        boolean successToCreateBonusNumber = false;

        do {
            try {
                outputView.printIntroduction(INPUT_BONUS_NUMBER.getIntroduction());
                return lottoService.convertBonusNumber(inputView.inputConstant(), winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printIntroduction(e.getMessage());
            }
        } while (!successToCreateBonusNumber);

        return null;
    }

    public void printWinning() {
        WinningPortfolio winningPortfolio = lottoService.confirmWin();
        outputView.printIntroduction(WINNING_STATISTICS.getIntroduction());
        outputView.printIntroduction(SEPARATOR.getIntroduction());
        outputView.printNotBonusPrize(FIFTH_PRIZE.getPrize(), winningPortfolio.getCountOfPrize(FIFTH_PRIZE.getPrize()));
        outputView.printNotBonusPrize(FOURTH_PRIZE.getPrize(), winningPortfolio.getCountOfPrize(FOURTH_PRIZE.getPrize()));
        outputView.printNotBonusPrize(THIRD_PRIZE.getPrize(), winningPortfolio.getCountOfPrize(THIRD_PRIZE.getPrize()));
        outputView.printBonusPrize(SECOND_PRIZE.getPrize(), winningPortfolio.getCountOfPrize(SECOND_PRIZE.getPrize()));
        outputView.printNotBonusPrize(FIRST_PRIZE.getPrize(), winningPortfolio.getCountOfPrize(FIRST_PRIZE.getPrize()));
        outputView.printRateOfReturn(winningPortfolio.getRateOfReturn().rateOfReturn());
    }
}
