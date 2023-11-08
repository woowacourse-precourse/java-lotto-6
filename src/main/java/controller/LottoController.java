package controller;

import domain.LottoAmount;
import domain.Lotto;
import view.InputView;
import view.outputView;


public class LottoController {
    public LottoController() {
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        try {
            int input = buyLotto();
            Lotto[] lottos = outputView.outputLottoNumber(input);
            String[] winnig = winningNumber();
            int bonus = checkDuplicate(winnig);
            outputView.compare(lottos, winnig, bonus, input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private int buyLotto() {
        String input = InputView.inputBuyLotto();

        try {
            LottoAmount.exceptionMessage(input);
            System.out.println();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    private String[] winningNumber() {
        try {
            String input = InputView.inputWinningNumber();
            System.out.println();
            LottoAmount.expression(input);
            String[] winning = input.split(",");
            LottoAmount.winningValid(winning);
            return winning;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningNumber();
        }
    }

    private int checkDuplicate(String[] winning) {
        try {
            int num = InputView.inputBonusNumber();
            LottoAmount.compareValid(winning, num);
            return num;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkDuplicate(winning);
        }
    }


}
