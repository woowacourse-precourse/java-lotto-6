package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

public class UserInputView {

    public static void inputPurchaseAmount(){
        try{
            LottoController.buyLottoTickets(Long.parseLong(Console.readLine()));

        }catch (IllegalArgumentException e){
            exceptionTypeMessage(e);
            inputPurchaseAmount();
        }
    }

    public static void inputWinningNums(){
        try{
            LottoController.putWinningNums(Console.readLine());

        }catch (IllegalArgumentException e){
            exceptionTypeMessage(e);
            inputWinningNums();
        }
    }

    public static  void inputBonusNum(){
        try{
            LottoController.putBonusNum(Console.readLine());
        }catch (IllegalArgumentException e){
            exceptionTypeMessage(e);
            inputBonusNum();
        }
    }

    private static void exceptionTypeMessage(IllegalArgumentException e){
        if(e instanceof NumberFormatException){
            System.out.println(ExceptionMessage.NumberFormatError.getErrorMessage());
            return;
        }
        if(e instanceof IllegalArgumentException){
            System.out.println(e.getMessage());
        }
    }
}
