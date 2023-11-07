package lotto.controller;

import lotto.*;
import lotto.util.ErrorMessage;
import lotto.validate.Check;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputWinningNumber;

public class LottoController {

    public static int setPurchaseAmount() {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputLottoAmount());
            return purchaseAmount.lottoCount();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INSERT_COIN.getMessage());
            return setPurchaseAmount();
        }
    }

    private static List<Integer> lottoNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        return lottoNumber.getNumbers();
    }

    public static List<Lotto> setLottoNumber(int amount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(lottoNumber());
            list.add(lotto);
        }
        return list;
    }

    public static List<Integer> lottoNumbers() {
        try {
            List<Integer> winningNumber = inputWinningNumber();
            Lotto lotto = new Lotto(winningNumber);
            return lotto.getNumbers();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoNumbers();
        }
    }

    public static int setBonusNumber(List<Integer> winningNumbers) {
        try {
            List<Integer> bonusNumber = inputBonusNumber();
            Check.bonusNumberCount(bonusNumber);
            Check.rightRange(bonusNumber);
            Check.numberDuplicate(winningNumbers,bonusNumber);
            return bonusNumber.get(0);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setBonusNumber(winningNumbers);
        }
    }
}
