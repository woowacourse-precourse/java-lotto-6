package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

public class UserInputView {

    public static void inputPurchaseAmount(){
        try{
            LottoController.createBuyLottoTickets(Long.parseLong(Console.readLine()));

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        }
    }

    public static void winningNumbers(){
        try{
            LottoController.putWinningNums(Console.readLine());

        }catch (IllegalAccessError e){
            System.out.println(e.getMessage());
            winningNumbers();
        }
    }
}
