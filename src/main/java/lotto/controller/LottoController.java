package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.OutputView;
import lotto.model.Quantity;
import lotto.model.RandomLotto;

import lotto.view.OutputView;

public class LottoController {
        private Lotto lotto;
        private RandomLotto randomLotto;
        private int quantity;
        private List<List<Integer>> randomNumbers;
        private List<Integer> lottoNumbers;

        public LottoController() {
                set();
                conduct();
                showResult();
        }

        public void set() {
                quantity = InputController.setQuantity();
                randomNumbers = InputController.setRandomNumbers(quantity);
        }

        public void conduct() {
                OutputView.printQuantity(quantity);
                OutputView.printRandomLotto(randomNumbers);
        }

        public void showResult() {

        }



}
