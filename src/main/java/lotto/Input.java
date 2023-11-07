package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    static int bonus;
    static int money;
    final static int LOTTO_WINNING_NUMBER_COUNT = 6;
    public static int money(){
        money = Integer.parseInt(Console.readLine());
        //TODO: exception 추가 - money가 1000으로 나누어 떨어지지 않을때
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
