package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String inputMoney(){
        System.out.println(MessageManager.ADD_COIN);
        return Console.readLine();
    }

    public String inputWinningNumber(){
        System.out.println(MessageManager.SET_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println(MessageManager.SET_BONUS_NUMBER);
        return Console.readLine();
    }
}
