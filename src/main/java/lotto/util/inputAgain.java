package lotto.util;

import lotto.model.Price;
import lotto.model.Winning;

import static lotto.util.InputUtil.inputPrice;
import static lotto.util.Parser.convertInt;
import static lotto.util.PriceException.validPrice;
import static lotto.view.InputView.buyLottoTickets;

public class inputController {
    public static Price createUserPrice() {
        while(true){
            buyLottoTickets();
            String tempPrice = inputPrice();
            try{
                validPrice(convertInt(tempPrice));
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Winning createWinningNumber() {
        while(true) {
            
        }
    }
}
