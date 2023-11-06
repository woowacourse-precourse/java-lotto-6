package lotto.controller;

import lotto.model.Lotto;
import lotto.view.OutputView;

public class LottoController {
        private Lotto lotto;
        private int quantityNum;

        public LottoController() {
                set();
                conduct();
                showResult();
        }

        public void set() {
                quantityNum = InputController.setQuantity();
        }

        public void conduct() {

        }

        public void showResult() {

        }



}
