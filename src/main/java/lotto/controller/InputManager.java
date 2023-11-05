package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    protected Boolean isItNumber(String readLine){
        try{
            Integer.parseInt(readLine);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(MessageManager.ERROR_IS_NOT_NUMBER);
            return false;
        }
    }

    protected Boolean isIt1000wonUnit(String readLine){
        if (Integer.parseInt(readLine) % 1000 != 0){
            System.out.println(MessageManager.ERROR_IS_NOT_1000_UNIT);
            return false;
        }else{
            return true;
        }
    }

    protected int checkAddCoinCondition(String readLine){
        if (isItNumber(readLine) && isIt1000wonUnit(readLine)){
            return Integer.parseInt(readLine);
        }else{
            return -1;
        }
    }
    public int inputMoney(){
        System.out.println(MessageManager.ADD_COIN);
        String readLine = Console.readLine();
        return checkAddCoinCondition(readLine);
    }
}
