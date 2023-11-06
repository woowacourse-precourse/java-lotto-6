package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.Ranks;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        Price purchasePrice = new Price(InputView.purchasePrice());
        List<Lotto> lottery = lottoController.buyLottery(purchasePrice);

        OutputView.printPurchaseResult(purchasePrice.numberLotteryAvailablePurchase());
        OutputView.printLotteryNumber(lottery);

        String stringWinningNumber = InputView.winningNumber();
        // todo 메서드 위치 변경 필요
        validateWinningNumber(stringWinningNumber);

        // todo 메서드 분리 필요
        List<LottoNumber> winningNumber = Arrays.stream(stringWinningNumber.split(","))
                .map(s -> Integer.valueOf(s))
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Ranks ranks = lottoController.lottoResults(lottery, winningNumber, new LottoNumber(InputView.bonusNumber()));

        OutputView.printLotteryResult(ranks.lotteryRankStatus());
        OutputView.printRateOfReturn(ranks.calWinningPrice(), purchasePrice);
    }

    private static void validateWinningNumber(String winningNumber) {
        String[] split = winningNumber.split(",");
        validateLength(split);
        validateType(split);
    }

    private static void validateType(String[] split) {
        try {
            for (String s : split) {
                Integer.valueOf(s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 금액은 숫자만 입력 가능합니다2.");
        }
    }

    private static void validateLength(String[] split) {
        if (split.length != 6) {
            throw new IllegalArgumentException("당첩 번호는 6개의 숫자로 입력되어야 합니다.");
        }
    }
}
