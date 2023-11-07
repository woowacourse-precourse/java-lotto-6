package lotto;

import lotto.data.Lotto;
import lotto.data.LottoResult;
import lotto.data.WinningNumber;
import lotto.provider.LottoProvider;
import lotto.provider.PrizeProvider;
import lotto.provider.WinningNumberProvider;
import lotto.utils.InputUtil;
import lotto.utils.PrintUtil;

import java.util.List;

public class LottoProgram {
    private String purchaseAmountInput;
    private final InputUtil inputUtil = new InputUtil();
    private final LottoProvider lottoProvider = new LottoProvider();
    private final WinningNumberProvider winningNumberProvider = new WinningNumberProvider();
    private final PrizeProvider prizeProvider = new PrizeProvider();

    public List<Lotto> buyLottos() {
        PrintUtil.printInputPurchaseMessage();
        String purchaseAmountInput = inputUtil.inputPurchaseAmount();
        this.purchaseAmountInput = purchaseAmountInput;

        List<Lotto> lottos = lottoProvider.buyLottos(purchaseAmountInput);

        PrintUtil.printPurchaseSuccessMessage(lottos.size());
        PrintUtil.printAllLottos(lottos);

        return lottos;
    }

    public List<Integer> inputWinningNumbers() {
        PrintUtil.printInputWinningNumberMessage();

        String winningNumberInput = inputUtil.inputWinningNumber();

        return winningNumberProvider.getWinningNumber(winningNumberInput);
    }

    public int inputBonus(List<Integer> winningNumber) {
        PrintUtil.printInputBonusNumberMessage();

        String bonusInput = inputUtil.inputBonus(winningNumber);

        return Integer.parseInt(bonusInput);
    }

    public void showLottoResult(WinningNumber winningNumber, List<Lotto> lottos) {
        LottoResult lottoResult = prizeProvider.getLottoResult(lottos, winningNumber);
        List<Integer> winningResult = lottoResult.getWinningResult();
        int totalPrize = lottoResult.getTotalPrize();

        PrintUtil.printWinningResultMessage(winningResult);

        double purchaseAmount = Double.parseDouble(purchaseAmountInput);
        double returnRate = (totalPrize/purchaseAmount)*100;

        PrintUtil.printReturnRateMessage(returnRate);
    }
}
