package lotto.controller;

import lotto.domain.RateOfReturnCalculator;
import lotto.domain.db.*;
import lotto.view.InputAboutLottoNumber;
import lotto.view.OutputAboutLotto;
import lotto.view.OutputAboutPurchaseAmount;
import lotto.view.OutputAboutResult;

public class LottoLauncher {
    public void start() {
        int lottoCount = PurchaseAmountController.amountControl();

        PurchaseLottoCollection purchaseLottoNumbers = SavePurchaseLottoController.lottoControl(lottoCount);
        for (PurchaseLotto lottos : purchaseLottoNumbers.getPurchaseLottos()) {
            OutputAboutLotto.printPurchaseLottoNumbers(lottos.getLottoNumbers());
        }
        OutputAboutLotto.printInputLottoNumber();
        String[] lottoNumber = InputAboutLottoNumber.readLottoNumber().split(",");
        OutputAboutLotto.printInputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(InputAboutLottoNumber.readBonusNumber());
        WinningLotto winningLottoNumbers = SaveLottoController.lottoControl(lottoNumber, bonusNumber.getBonus());
        OutputAboutResult.printIntroduceWinnerResult();
        int[] result = SaveResultController.resultControl(purchaseLottoNumbers, winningLottoNumbers);
        float rateOfResult = new RateOfReturnCalculator().calculate(result, lottoCount);
        OutputAboutResult.printWinnerResult(result);
        OutputAboutResult.printRateOfReturn(rateOfResult);


    }
}
