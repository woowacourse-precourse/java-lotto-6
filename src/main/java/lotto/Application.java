package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.Ranks;
import lotto.validate.LottoNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        Price purchasePrice = getPurchasePrice();
        List<Lotto> lottery = lottoController.buyLottery(purchasePrice);

        OutputView.printPurchaseResult(purchasePrice.numberLotteryAvailablePurchase());
        OutputView.printLotteryNumber(lottery);

        String stringWinningNumber = getWinningNumber();
        List<LottoNumber> winningNumber = toLottoNumbers(stringWinningNumber);

        Ranks ranks = lottoController.lottoResults(lottery, winningNumber, new LottoNumber(InputView.bonusNumber()));

        OutputView.printLotteryResult(ranks.lotteryRankStatus());
        OutputView.printRateOfReturn(ranks.calWinningPrice(), purchasePrice);
    }

    private static List<LottoNumber> toLottoNumbers(String stringWinningNumber) {
        List<LottoNumber> winningNumber = Arrays.stream(stringWinningNumber.split(","))
                .map(s -> Integer.valueOf(s))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return winningNumber;
    }

    private static Price getPurchasePrice() {
        String purchasePrice = InputView.purchasePrice();
        return toPrice(purchasePrice);
    }

    private static Price toPrice(String purchasePrice) {
        boolean isRestart = true;
        Price price = null;
        try {
            price = new Price(purchasePrice);
            isRestart = false;
        } catch (IllegalArgumentException e) {
            OutputView.printCustomMessage(e.getMessage());
        }

        if (isRestart) {
            getPurchasePrice();
        }
        return price;
    }

    private static String getWinningNumber() {
        String stringWinningNumber = InputView.winningNumber();
        validateWinningNumber(stringWinningNumber);
        return stringWinningNumber;
    }

    private static void validateWinningNumber(String stringWinningNumber) {
        boolean isRestart = true;
        try {
            isRestart = LottoNumberValidator.validateWinningNumber(stringWinningNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printCustomMessage(e.getMessage());
        }
        if (isRestart) {
            getWinningNumber();
        }
    }

}
