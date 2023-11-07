package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    public static LottoTickets inputPurchaseAmount(){
        try{
            return LottoTickets.crateBuyLottoTickets(Long.parseLong(Console.readLine()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
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
