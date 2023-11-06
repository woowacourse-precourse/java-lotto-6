package lotto.controller;

import lotto.domain.db.*;
import lotto.view.InputAboutLottoNumber;
import lotto.view.OutputAboutLotto;
import lotto.view.OutputAboutPurchaseAmount;

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


    }
}
