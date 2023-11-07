package lotto.controller;

import lotto.InputView.InputView;

public class LottoController {
    public LottoController(){
    }

    public void run() {
        boolean validAmountEntered = false;
        while (!validAmountEntered) {
            try {
                start();
                validAmountEntered = true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("올바른 입력을 다시 시도하세요.");
            }
        }
    }

    public int start() {
        int ticketAmount = InputView.getAmount();
        return ticketAmount;
    }
}
