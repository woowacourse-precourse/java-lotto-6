package lotto.util;

import lotto.model.BonusNumber;
import lotto.model.Price;
import lotto.model.Winning;

import java.util.List;

import static lotto.util.InputUtil.*;
import static lotto.util.Parser.*;
import static lotto.util.PriceException.priceException;
import static lotto.util.WinningException.bonusException;
import static lotto.util.WinningException.winningException;
import static lotto.view.InputView.*;

public class inputAgain {
    public static Price createUserPrice() {
        while(true){
            buyLottoTickets();
            String tempPrice = inputPrice();
            try{
                 return priceException(convertInt(tempPrice));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Winning createWinningNumber() {
        while(true) {
            requestLottoNumber();
            String tmpWinningNumbers = inputWinningNumbers();
            try{
                return winningException(convertWinningNum(tmpWinningNumbers), tmpWinningNumbers);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber createBonusNumber(List<Integer> numbers) {
        System.out.println();
        while(true) {
           requestBonusNumber();
           String tmpBonusNumber = inputBonusNumber();
           try{
               return bonusException(numbers,convertInt(tmpBonusNumber));
           } catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
           }
        }
    }
}
