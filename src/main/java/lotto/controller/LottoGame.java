package lotto.controller;

import lotto.view.InputMoneyView;
import lotto.view.OutputView;

public class LottoGame {
    private final int THOUSAND = 1000;
    private final OutputView outputView = new OutputView();
    private final InputMoneyView inputMoneyView = new InputMoneyView();

    public void run() {
        int money = input();
    }

    private int input(){
        outputView.inputMoney();

        while(true){
            try {
                int number = inputMoneyView.Number();
                if(number != 0){
                    return number;
                }
            }   catch (IllegalArgumentException e){
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }
    }
}

