package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    static int bonus;
    static int money;
    final static int LOTTO_WINNING_NUMBER_COUNT = 6;
    public static int money(){
        while(true) {
            try {
                money = Integer.parseInt(Console.readLine());
                if (!Exception.isValidMoney(money)) {
                    System.out.println("구입금액은 1000단위 정수만 입력할 수 있습니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e){
                System.out.println("구입금액은 1000단위 정수만 입력할 수 있습니다.");
            }
        }
        return money;
    }

    public static List<Integer> winningNumbers(){
        String winningNumbers = Console.readLine();
        return LottoGame.MakeWinningNumbers(winningNumbers);
    }

    public static int bonusNumber(){
        bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }
}
