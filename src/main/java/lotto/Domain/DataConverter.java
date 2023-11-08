package lotto.Domain;

import lotto.Domain.Constants.LottoRules;
import lotto.Domain.Constants.PrizePot;

import java.util.ArrayList;
import java.util.List;

public class DataConverter {

    public static long gameMoney(String gameMoneyInput) {
        long money = Long.parseLong(gameMoneyInput);
        Verifier.underOneThousand(money);
        return money;
    }

    public static long gameQuantity(long gameMoney) {
        Verifier.moduloExist(gameMoney);
        return gameMoney / LottoRules.GAME_FEE.getNumber();
    }


    public static List<String> winningInput (String winningNumberInput) {
        Verifier.winningInput(winningNumberInput);
        return new ArrayList<>(List.of(winningNumberInput.split(",")));
    }

    public static List<Integer> winningBalls (List<String> winningInput) {
        List<Integer> numbers = new ArrayList<>();

        for(String str : winningInput){
            numbers.add(Integer.parseInt(str));
        }

        Verifier.winningBall(numbers);
        return numbers;
    }

    public static int bonusBall (String bonusInput, List<Integer> winningBalls) {
        int bonus = Integer.parseInt(bonusInput);
        Verifier.bonusNumber(bonus,winningBalls);
        return bonus;
    }


    public static long profitSum(List<Integer> correctType) {
        long sum =0;
        PrizePot[] prize = PrizePot.values();
        for (int i = 0; i < correctType.size(); i++) {
            sum += prize[i].getWon() * correctType.get(i);
        }
        return sum;
    }

    public static double profitPercent (double profitSum, double price){
        return 100 + ((profitSum - price)/ price) * 100;
    }

}
