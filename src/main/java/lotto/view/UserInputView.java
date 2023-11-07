package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoTickets;

public class UserInputView {

    public static void inputPurchaseAmount(){
        try{
            LottoTickets.createBuyLottoTickets(Long.parseLong(Console.readLine()));

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        }
    }

    public static void winningNumbers(){
        try{

        }catch (IllegalAccessError e){
            System.out.println(e.getMessage());
            winningNumbers();
        }
    }
}
