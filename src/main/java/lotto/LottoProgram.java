package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.data.Lotto;
import lotto.data.LottoResult;
import lotto.data.WinningNumber;
import lotto.provider.BonusProvider;
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
    private final BonusProvider bonusProvider = new BonusProvider();
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

        String winningNumberInput = Console.readLine();

        return winningNumberProvider.getWinningNumber(winningNumberInput);
    }

    public int inputBonus(List<Integer> winningNumbers) {
        PrintUtil.printInputBonusNumberMessage();

        String bonusInput = Console.readLine();

        return bonusProvider.getBonus(winningNumbers, bonusInput);
    }

    public void showLottoResult(WinningNumber winningNumber, List<Lotto> lottos) {
        LottoResult lottoResult = prizeProvider.getLottoResult(lottos, winningNumber);
        List<Integer> winningResult = lottoResult.getWinningResult();
        int totalPrize = lottoResult.getTotalPrize();

        PrintUtil.printWinningResultMessage(winningResult);

        PrintUtil.printReturnRateMessage((totalPrize/Double.parseDouble(purchaseAmountInput))*100);
    }
}
