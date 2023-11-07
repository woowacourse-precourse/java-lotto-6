package lotto.controller;

import lotto.domain.*;

import java.util.List;

import static lotto.domain.Lotto.stringToList;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public void start() {
        LottoAmount lottoAmount = inputAmount();
        printLottos(lottoAmount);

        getWinningLotto(inputWinningNumber());



    }

    private LottoAmount inputAmount() {
        try {
            return new LottoAmount(inputPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }


    private Lotto inputWinningNumber() {
        try {
            List<Integer> LottoList = stringToList(inputPrizeNumber());
            return new Lotto(LottoList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    public WinningNumber getWinningLotto(Lotto lotto) {
        String bonusNumber = inputBonus();
        try {
            return new WinningNumber(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto(lotto);
        }
    }

}
