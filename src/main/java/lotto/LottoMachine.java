package lotto;

import java.util.List;
import lotto.model.LottoTicket;
import lotto.model.winninglotto.LottoWinningResult;
import lotto.model.winninglotto.WinningLotto;
import lotto.util.NumberConvertor;
import lotto.util.PurchaseCountCalculator;
import lotto.view.BillAcceptor;
import lotto.view.LottoNumberInput;
import lotto.view.Screen;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final Screen screen;
    private final BillAcceptor billAcceptor;
    private final LottoNumberInput lottoNumberInput;

    public LottoMachine(Screen screen, BillAcceptor billAcceptor, LottoNumberInput lottoNumberInput) {
        this.screen = screen;
        this.billAcceptor = billAcceptor;
        this.lottoNumberInput = lottoNumberInput;
    }

    public void start() {
        int userLottoPurchaseCount = getUserLottoPurchaseCount();
        LottoTicket lottoTicket = purchaseLottoTicket(userLottoPurchaseCount);
        WinningLotto winningLotto = getWinningLotto();
        getLottoResult(winningLotto, lottoTicket, userLottoPurchaseCount);
    }

    private int getUserLottoPurchaseCount() {
        try {
            int userInsertAmount = billAcceptor.acceptBill();
            return PurchaseCountCalculator.calculatePurchaseCount(userInsertAmount, LOTTO_PRICE);
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
        String winningNumberInput = lottoNumberInput.requestWinningNumberInput();
        return NumberConvertor.convertToNumbers(winningNumberInput);
    }

    private Integer getBonusNumber() {
        String bonusNumberInput = lottoNumberInput.requestBonusNumberInput();
        return NumberConvertor.convertToNumber(bonusNumberInput);
    }

    private void getLottoResult(WinningLotto winningLotto, LottoTicket lottoTicket, int purchaseCount) {
        LottoWinningResult lottoResult = winningLotto.getLottoResult(lottoTicket.getLottoTicket());
        double profitRate = lottoResult.getLottoProfitRate(purchaseCount * LOTTO_PRICE);
        screen.printLottoResult(lottoResult, profitRate);
    }
}
