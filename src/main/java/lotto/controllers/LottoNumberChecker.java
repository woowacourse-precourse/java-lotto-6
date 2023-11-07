package lotto.controllers;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoNumberMatcher;

import java.util.ArrayList;

import static lotto.controllers.DongHangLottery.getInputBonusNumber;
import static lotto.controllers.DongHangLottery.getInputWinningNumber;
import static lotto.controllers.LottoStoreManager.lottoMachine;

public class LottoNumberChecker {
    public void comparisonMyLottoNumberAndWinningNumber() {
        ArrayList<Lotto> myLottoNumbers = lottoMachine();
        String winningNumber = getInputWinningNumber();
        String inputBonusNumber = getInputBonusNumber();
        LottoNumberMatcher lotteryPrize = new LottoNumberMatcher();

        lotteryPrize.checkWinning(myLottoNumbers,winningNumber,inputBonusNumber);

    }
}
