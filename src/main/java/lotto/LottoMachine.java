package lotto;

import java.util.List;
import lotto.model.LottoTicket;
import lotto.model.winninglotto.LottoWinningResult;
import lotto.model.winninglotto.WinningLotto;
import lotto.util.NumberConvertor;
import lotto.util.PurchaseAmountConvertor;
import lotto.util.PurchaseCountCalculator;
import lotto.view.NumberInput;
import lotto.view.Screen;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final Screen screen;
    private final NumberInput numberInput;

    public LottoMachine(Screen screen, NumberInput numberInput) {
        this.screen = screen;
        this.numberInput = numberInput;
    }

    public void start() {
        int purchaseCount = getUserLottoPurchaseCount();
        LottoTicket lottoTicket = purchaseLottoTicket(purchaseCount);
        WinningLotto winningLotto = getWinningLotto();
        getLottoResult(winningLotto, lottoTicket, purchaseCount);
    }

    private int getUserLottoPurchaseCount() {
        try {
            String purchaseAmountInput = numberInput.requestPurchaseAmountInput();
            int purchaseAmount = PurchaseAmountConvertor.convert(purchaseAmountInput);
            return PurchaseCountCalculator.calculatePurchaseCount(purchaseAmount, LOTTO_PRICE);
        } catch (IllegalArgumentException illegalArgumentException) {
            screen.printErrorMessage(illegalArgumentException.getMessage());
            return getUserLottoPurchaseCount();
        }
    }

    private LottoTicket purchaseLottoTicket(int userLottoPurchaseCount) {
        LottoTicket lottoTicket = LottoTicket.issueLottoTicket(userLottoPurchaseCount);
        screen.printLottoTicket(userLottoPurchaseCount, lottoTicket);
        return lottoTicket;
    }

    private WinningLotto getWinningLotto() {
        try {
            List<Integer> winningNumbers = getWinningNumbers();
            Integer bonusNumber = getBonusNumber();
            return WinningLotto.createWinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            screen.printErrorMessage(illegalArgumentException.getMessage());
            return getWinningLotto();
        }
    }

    private List<Integer> getWinningNumbers() {
        String winningNumberInput = numberInput.requestWinningNumberInput();
        return NumberConvertor.convertToNumbers(winningNumberInput);
    }

    private Integer getBonusNumber() {
        String bonusNumberInput = numberInput.requestBonusNumberInput();
        return NumberConvertor.convertToNumber(bonusNumberInput);
    }

    private void getLottoResult(WinningLotto winningLotto, LottoTicket lottoTicket, int purchaseCount) {
        LottoWinningResult lottoResult = winningLotto.getLottoResult(lottoTicket.getLottoTicket());
        double profitRate = lottoResult.getLottoProfitRate(purchaseCount * LOTTO_PRICE);
        screen.printLottoResult(lottoResult, profitRate);
    }
}
