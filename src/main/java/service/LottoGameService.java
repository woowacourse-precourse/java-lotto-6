package service;

import camp.nextstep.edu.missionutils.Console;
import constants.ErrorCodeConstant;
import constants.LottoGameMessage;
import domain.UserLotto;

public class LottoGameService {
    private UserLotto userLotto;

    public void purchasedLotto(){
        print(LottoGameMessage.PURCHASE_AMOUNT.toString());

        boolean isAmount = false;
        while(!isAmount){
            String purchasedAmount = readInput();
           isAmount = isGetUserLotto(purchasedAmount);
        }
    }

    public boolean isGetUserLotto(String purchasedAmount){
        try{
            userLotto = new UserLotto(purchasedAmount);
        }catch (IllegalArgumentException iae){
            errorPrint(iae.getMessage());
            return false;
        }
        return true;
    }

    private void print(String message){
        System.out.println(message);
    }
    private void errorPrint(String message){
        System.out.println(ErrorCodeConstant.DEFAULT_ERROR + message);
    }
    private String readInput(){
        return Console.readLine();
    }

}
