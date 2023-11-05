package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputManager {
    private NumberManager numberManager;

    public InputManager() {
        this.numberManager = new NumberManager();
    }

    public int inputMoney(){
        System.out.println(MessageManager.ADD_COIN);
        String readLine = Console.readLine();
        return numberManager.checkAddCoinCondition(readLine);
    }

    public Lotto inputWinningNumber(){
        System.out.println(MessageManager.SET_WINNING_NUMBER);
        String readLine = Console.readLine();

        List<String> seperateNumbers = separateWinningNumber(readLine);

        if(!numberManager.isItContainOnlyNumber(seperateNumbers)){
            return null;
        }

        List<Integer> numbers = numberManager.changeToNumber(seperateNumbers);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    protected List<String> separateWinningNumber(String readLine){
        return Arrays.stream(readLine.split(","))
                .toList();
    }
}
