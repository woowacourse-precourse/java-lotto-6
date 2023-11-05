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

    public int inputBonusNumber(Lotto lotto){
        String readLine;
        do {
            System.out.println(MessageManager.SET_BONUS_NUMBER);
            readLine = Console.readLine();

        }while(numberManager.checkBonusNumberCondition(readLine, lotto));

        return Integer.parseInt(readLine);
    }

    protected List<String> separateWinningNumber(String readLine){
        return Arrays.stream(readLine.split(","))
                .toList();
    }
}
