package lotto.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoOrder;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.domain.constant.LottoConstant;
import lotto.domain.number.RandomNumberGenerator;
import lotto.util.Convertor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoFactory lottoFactory;

    public LottoController() {
        this.lottoFactory = new LottoFactory(new RandomNumberGenerator());
    }

    public void startGame() {
        Money bettingMoney = getBettingMoney();
        LottoOrder lottoOrder = createLottoOrder(bettingMoney);
        displayLottoOrder(lottoOrder);
        LottoResult lottoResult = calculateLottoResult(lottoOrder);
        float profitRate = calculateProfitRate(bettingMoney, lottoResult);
        displayGameResult(lottoResult, profitRate);
    }

    private static Money getBettingMoney() {
        return tryUntilSuccess(InputView::inputMoney, Money::of);
    }

    private LottoOrder createLottoOrder(final Money money) {
        int quantity = money.calculateLottoQuantity(LottoConstant.PRICE.getValue());
        return LottoOrder.of(money, lottoFactory.createBundle(quantity));
    }

    private static void displayLottoOrder(final LottoOrder lottoOrder) {
        OutputView.printBuyQuantity(lottoOrder, LottoConstant.PRICE.getValue());
        OutputView.printBuyLotto(lottoOrder.getLottos());
    }

    private LottoResult calculateLottoResult(final LottoOrder lottoOrder) {
        Lotto winningNumber = getInputWinningLottoNumbers();
        return LottoResult.of(lottoOrder.getLottos(), createWinningLotto(winningNumber));
    }

    private static Lotto getInputWinningLottoNumbers() {
        return tryUntilSuccess(InputView::inputWinningLottoNumbers,
                input -> new Lotto(Convertor.convertToIntegerList(input)));
    }

    private static WinningNumber createWinningLotto(final Lotto winningNumber) {
        return tryUntilSuccess(() -> BonusNumber.of(InputView.inputBonusLottoNumber()),
                bonusNumber -> new WinningNumber(winningNumber, bonusNumber));
    }

    private static float calculateProfitRate(final Money money, final LottoResult lottoResult) {
        return money.calculateLottoProfitRate(lottoResult.calculatePrize());
    }

    private static void displayGameResult(final LottoResult lottoResult, float profitRate) {
        OutputView.printResultMessage();
        OutputView.printLottoResult(lottoResult);
        OutputView.printProfitRate(profitRate);
    }

    private static <T, R> R tryUntilSuccess(final Supplier<T> inputSupplier, final Function<T, R> constructor) {
        try {
            return constructor.apply(inputSupplier.get());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return tryUntilSuccess(inputSupplier, constructor);
        }
    }
}