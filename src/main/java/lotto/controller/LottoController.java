package lotto.controller;

import lotto.domain.LottoJudgment;

import java.util.ArrayList;

import static lotto.domain.UserInput.*;

public class LottoController {

    public void run() {
        int purchaseAmount = inputPurchaseAmount();

        LottoJudgment lottoJudgment = new LottoJudgment(purchaseAmount);

        ArrayList<Integer> lottoNumbers = inputWinningNumber();

        int bonusNumber = inputBonusNumber(lottoNumbers);

        lottoJudgment.confirmWinningLotto(lottoNumbers , bonusNumber);
    }

}
