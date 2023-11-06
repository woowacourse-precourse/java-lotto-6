package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    public static List<Lotto> inputPurchaseAmount(){
        try{
            return Lotto.buyLottoTickets(Long.parseLong(Console.readLine()));
        }catch (IllegalAccessError e){
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }
}
