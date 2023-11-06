package lotto.controller;

import lotto.model.Lotto;
import lotto.view.OutputView;
import lotto.model.Quantity;

public class LottoController {
        private Lotto lotto;
        private int quantity;

        public LottoController() {
                set();
                conduct();
                showResult();
        }

        public void set() {
                quantity = InputController.setQuantity();
        }

        public void conduct() {

        }

        public void showResult() {

        }



}
