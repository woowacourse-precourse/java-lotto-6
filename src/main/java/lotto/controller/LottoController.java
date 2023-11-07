package lotto.controller;

import lotto.*;
import lotto.util.ErrorMessage;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

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
}
