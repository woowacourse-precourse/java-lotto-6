package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import static lotto.Constant.*;
import static lotto.Validation.*;

public class UI {
    public static int getMoney() {
        while (true) {
            try{
                System.out.println(GET_MONEY_MSG);
                String input = Console.readLine();
                validateMoney(input);
                return Integer.parseInt(input);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printLottos(int amount, List<Lotto> lottos){
        System.out.println();
        System.out.println(Integer.toString(amount) + LOTTO_AMOUNT_MSG);
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Integer> getWinningNumber(){
        System.out.println();
        while (true) {
            try{
                System.out.println(GET_WINNING_NUMBER_MSG);
                String input = Console.readLine();
                return validateWinningNumber(input);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(){
        System.out.println();
        while (true) {
            try{
                System.out.println(GET_BONUS_NUMBER_MSG);
                String input = Console.readLine();
                validateBonusNumber(input);
                return Integer.parseInt(input);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
