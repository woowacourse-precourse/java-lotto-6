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

        Price purchasePrice = new Price(InputView.purchasePrice());
        List<Lotto> lottery = lottoController.buyLottery(purchasePrice);

        OutputView.printPurchaseResult(purchasePrice.numberLotteryAvailablePurchase());
        OutputView.printLotteryNumber(lottery);

        String stringWinningNumber = getWinningNumber();

        // todo 메서드 분리 필요
        List<LottoNumber> winningNumber = Arrays.stream(stringWinningNumber.split(","))
                .map(s -> Integer.valueOf(s))
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Ranks ranks = lottoController.lottoResults(lottery, winningNumber, new LottoNumber(InputView.bonusNumber()));

        OutputView.printLotteryResult(ranks.lotteryRankStatus());
        OutputView.printRateOfReturn(ranks.calWinningPrice(), purchasePrice);
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
