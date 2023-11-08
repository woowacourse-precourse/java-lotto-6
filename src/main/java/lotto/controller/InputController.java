package lotto.controller;

import java.util.List;
import lotto.Constants;
import lotto.model.*;
import lotto.view.InputView;

public class InputController {

        public static int setQuantity() {
                try {
                        PurchaseAmountValidator validation = new PurchaseAmountValidator(InputView.purchaseInput());
                        int purchaseAmount = Integer.parseInt(validation.PURCHASE_STRING);
                        Quantity quantity = new Quantity(purchaseAmount);
                        return quantity.quantityNum;
                } catch (IllegalArgumentException e) {
                        System.out.println(Constants.PURCHASE_WRONG_ERROR);
                        return setQuantity();
                }
        }



        public static List<List<Integer>> setRandomNumbers(int quantity) {
                RandomLotto randomLotto = new RandomLotto(quantity);
                return randomLotto.randomLotto;
        }

        public static List<Integer> setLottoNumbers() {
                try {
                       LottoNumValidator validator = new LottoNumValidator(InputView.winningNumberInput());
                       return validator.LOTTO_NUMBER;
                } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        return setLottoNumbers();
                }
        }

        public static int setBonusNumber(List<Integer> lottoNumbers) {
                try {
                        BonusNumValidator validator = new BonusNumValidator(lottoNumbers, InputView.bonusNumberInput());
                        return validator.BONUS_NUM;
                } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        return setBonusNumber(lottoNumbers);
                }
        }
}

