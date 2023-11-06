package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.data.Lotto;
import lotto.data.LottoResult;
import lotto.data.WinningNumber;
import lotto.error.Error;
import lotto.provider.BonusProvider;
import lotto.provider.LottoProvider;
import lotto.provider.PrizeProvider;
import lotto.provider.WinningNumberProvider;
import lotto.utils.PrintUtil;

import java.util.List;

public class LottoProgram {
    private String purchaseAmountInput;

    public List<Lotto> buyLottos() {
        PrintUtil.printInputPurchaseMessage();
        String purchaseAmountInput = Console.readLine();
        validateInteger(purchaseAmountInput);
        this.purchaseAmountInput = purchaseAmountInput;

        LottoProvider lottoProvider = new LottoProvider();

        List<Lotto> lottos = lottoProvider.buyLottos(purchaseAmountInput);

        PrintUtil.printPurchaseSuccessMessage(lottos.size());
        PrintUtil.printAllLottos(lottos);

        return lottos;
    }

    public List<Integer> inputWinningNumbers() {
        PrintUtil.printInputWinningNumberMessage();

        String winningNumberInput = Console.readLine();
        WinningNumberProvider winningNumberProvider = new WinningNumberProvider();

        return winningNumberProvider.getWinningNumber(winningNumberInput);
    }

    public int inputBonus(List<Integer> winningNumbers) {
        PrintUtil.printInputBonusNumberMessage();

        String bonusInput = Console.readLine();
        BonusProvider bonusProvider = new BonusProvider();

        return bonusProvider.getBonus(winningNumbers, bonusInput);
    }

    public void showLottoResult(WinningNumber winningNumber, List<Lotto> lottos) {
        PrizeProvider prizeProvider = new PrizeProvider();

        LottoResult lottoResult = prizeProvider.getLottoResult(lottos, winningNumber);
        List<Integer> winningResult = lottoResult.getWinningResult();
        int totalPrize = lottoResult.getTotalPrize();

        PrintUtil.printWinningResultMessage(winningResult);

        PrintUtil.printReturnRateMessage((totalPrize/Double.parseDouble(purchaseAmountInput))*100);
    }

    private void validateInteger(String input) {
        // 숫자가 아닌 경우 예외 발생
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Error.LOTTO_PURCHASE_AMOUNT_ERROR.getMessage());
        }
    }
}
