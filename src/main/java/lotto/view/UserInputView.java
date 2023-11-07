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
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        }
    }

    public static void putWinningNums(){
        try{
            LottoController.putWinningNums(Console.readLine());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            putWinningNums();
        }
    }

    public static  void putBonusNum(){
        try{
            LottoController.putBonusNum(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            putBonusNum();
        }
    }
}
