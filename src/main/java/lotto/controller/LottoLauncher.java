package lotto.controller;

import lotto.constant.Phrases;
import lotto.domain.RateOfReturnCalculator;
import lotto.domain.db.*;
import lotto.exception.bonusNumber.BonusNumberException;
import lotto.util.StringToNumberListParser;
import lotto.view.*;

import java.util.Arrays;

public class LottoLauncher {
    public void start() {
        int lottoCount = PurchaseAmountController.amountControl();

        PurchaseLottoCollection purchaseLottoNumbers = SavePurchaseLottoController.lottoControl(lottoCount);
        for (PurchaseLotto lottos : purchaseLottoNumbers.getPurchaseLottos()) {
            OutputAboutLotto.printPurchaseLottoNumbers(lottos.getLottoNumbers());
        }

        String[] lottoNumber;

        while (true) {
            try {
                OutputAboutLotto.printInputLottoNumber();
                lottoNumber = InputAboutLottoNumber.readLottoNumber().split(",");
                WinningLotto test = new WinningLotto
                        (new StringToNumberListParser().StringToIntlistParsing(Arrays.asList(lottoNumber)));
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputAboutException.printException(Phrases.wrongSizeExceptionPhrase);
            }
        }

        BonusNumber bonusNumber;

        while (true) {
            try {
                OutputAboutLotto.printInputBonusNumber();
                bonusNumber = new BonusNumber(InputAboutLottoNumber.readBonusNumber());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputAboutException.printException(Phrases.wrongSizeExceptionPhrase);
            }
        }

        WinningLotto winningLottoNumbers = SaveLottoController.lottoControl(lottoNumber, bonusNumber.getBonus());

//        new BonusNumberException().bonusNumberDuplication(bonusNumber.getBonus(), winningLottoNumbers.getLottoNumbers());
        OutputAboutResult.printIntroduceWinnerResult();

        int[] result = SaveResultController.resultControl(purchaseLottoNumbers, winningLottoNumbers);
        float rateOfResult = new RateOfReturnCalculator().calculate(result, lottoCount);
        OutputAboutResult.printWinnerResult(result);
        OutputAboutResult.printRateOfReturn(rateOfResult);


    }
}
