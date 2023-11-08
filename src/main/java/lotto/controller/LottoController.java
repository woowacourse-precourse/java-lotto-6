package lotto.controller;

import java.util.List;
import java.util.Random;
import lotto.Constants;
import lotto.model.Lotto;
import lotto.view.OutputView;
import lotto.model.Quantity;
import lotto.model.RandomLotto;

import lotto.Prize;

import lotto.view.OutputView;

public class LottoController {
        private Lotto lotto;
        private RandomLotto randomLotto;
        private int quantity;
        private List<List<Integer>> randomNumbers;
        private List<Integer> lottoNumbers;
        private int bonusNumber;

        public LottoController() {
                setStart();
                showStart();
                set();
                calculate();
        }

        public void setStart() {
                quantity = InputController.setQuantity();
                randomNumbers = InputController.setRandomNumbers(quantity);
        }

        public void showStart() {
                OutputView.printQuantity(quantity);
                OutputView.printRandomLotto(randomNumbers);
        }

        public void set() {
                lottoNumbers = InputController.setLottoNumbers();
                bonusNumber = InputController.setBonusNumber(lottoNumbers);
                Lotto lotto = new Lotto(lottoNumbers);
        }

        public void calculate() {
                lotto.getWinningData(randomNumbers,bonusNumber);
                lotto.calculatePrize();
                lotto.calculateCost();
                lotto.calculateReturn();
        }
}
