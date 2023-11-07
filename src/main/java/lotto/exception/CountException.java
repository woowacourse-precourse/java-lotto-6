package lotto.exception;

import lotto.controller.MessageManager;

public class CountException {
    public void isItNumber(String readLine){
        try{
            Integer.parseInt(readLine);
        }catch (IllegalArgumentException e){
            System.out.println(MessageManager.ERROR_IS_NOT_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public void isIt1000wonUnit(String readLine){
        if (Integer.parseInt(readLine) % 1000 != 0){
            System.out.println(MessageManager.ERROR_IS_NOT_1000_UNIT);
            throw new IllegalArgumentException();
        }
    }

    public void isItPositiveNumber(String readLine){
        if (Integer.parseInt(readLine) < 0) {
            System.out.println(MessageManager.ERROR_IS_NOT_POSITIVE);
            throw new IllegalArgumentException();
        }
    }
}
