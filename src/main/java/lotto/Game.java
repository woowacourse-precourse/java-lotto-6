package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.view.View;


public class Game {
    private static final int LOTTO_PRICE = 1000;

    private int money;
    private View view;

    public Game(){
        view = new View();
    }

    public void play(){
        getMoneyFromUserInput();
    }

    private void getMoneyFromUserInput(){
        money = inputMoney();
    }

    private int inputMoney(){
        view.request_InputMoney();
        return Integer.parseInt(Console.readLine());
    }

}
