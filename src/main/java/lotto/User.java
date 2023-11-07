package lotto;

import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import static lotto.Constant.*;
import static lotto.Validation.*;

public class User {
    public static int getMoney() {
        while (true) {
            try{
                System.out.println(GET_MONEY_MSG);
                String input = Console.readLine();
                validateMoney(input);
                return Integer.parseInt(input);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static void printLottos(int amount, List<Lotto> lottos){
        System.out.println();
        System.out.println(amount + LOTTO_AMOUNT_MSG);
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Integer> getWinningNumber(){
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

    public static int getBonusNumber(List<Integer> winningNumber){
        while (true) {
            try{
                System.out.println(GET_BONUS_NUMBER_MSG);
                String input = Console.readLine();
                validateBonusNumber(input, winningNumber);
                return Integer.parseInt(input);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printResult(Map<Rank, Integer> result){
        System.out.println(PRINT_RESULT_MSG);
        for (Rank rank : Rank.values()){
            printRank(rank, result.get(rank));
        }
    }

    public static void printRank(Rank rank, int amount){
        if (rank != Rank.MISS){
            System.out.println(rank.getMessage() + amount+AMOUNT_MSG);
        }
    }

}
