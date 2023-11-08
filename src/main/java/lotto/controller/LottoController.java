package lotto.controller;

import java.util.List;
import lotto.Constants;
import lotto.model.Lotto;
import lotto.view.OutputView;

public class LottoController {
        private Lotto lotto;
        private int quantity;
        private List<List<Integer>> randomNumbers;
        private List<Integer> lottoNumbers;

        private int bonusNumber;

        public LottoController() {
                setStart();
                showStart();
                set();
                calculate();
                printResult();
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
                this.lotto = new Lotto(lottoNumbers);
        }

        public void calculate() {
                lotto.getWinningData(randomNumbers,bonusNumber);
                int ticketCost = quantity * Constants.COST;
                lotto.setCost(ticketCost);
                lotto.calculateReturn();
                lotto.setWinningCount();
        }



        public void printResult() {
                OutputView.printWinningData(lotto.getCount());
                OutputView.printRate(lotto.getValue());
        }
}
