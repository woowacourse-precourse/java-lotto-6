package lotto;

import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoReceipt;
import lotto.domain.ProfitCalculator;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.exception.LottoIllegalArgumentException;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;
import lotto.service.PurchaseService;

public class LottoClient {
    private final PurchaseService purchaseService;
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final ProfitCalculator profitCalculator;

    public LottoClient(PurchaseService purchaseService,
                       LottoInput lottoInput,
                       LottoOutput lottoOutput,
                       ProfitCalculator profitCalculator) {
        this.purchaseService = purchaseService;
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
        this.profitCalculator = profitCalculator;
    }

    public void startLottery() {
        LottoReceipt lottoReceipt = repeatUntilValid(this::purchaseLotto);
        lottoOutput.printLottoReceipt(lottoReceipt);

        Lotto winningLotto = repeatUntilValid(this::askAndGetWinningLotto);
        LottoBall bonusBall = repeatUntilValid(this::askAndGetBonusBall);
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusBall);

        Map<Rank, Integer> results = lottoReceipt.getResults(winningNumbers);
        lottoOutput.printResults(results);

        double profitRate = profitCalculator.calculateProfitRateInPercentage(results);
        lottoOutput.printProfitAsPercentage(profitRate);
    }
    
    private LottoReceipt purchaseLotto() {
        lottoOutput.printAskingMoney();
        int money = lottoInput.getMoneyAmount();
        return purchaseService.purchaseLotto(money);
    }

    private Lotto askAndGetWinningLotto() {
        lottoOutput.printAskingWinningNumbers();
        return lottoInput.getLotto();
    }
    private LottoBall askAndGetBonusBall() {
        lottoOutput.printAskingBonusNumber();
        return lottoInput.getBall();
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (LottoIllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(function);
        }
    }
}
