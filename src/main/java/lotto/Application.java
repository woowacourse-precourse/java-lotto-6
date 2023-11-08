package lotto;

import static lotto.domain.CalEarn.CalEarn;
import static lotto.domain.CompareNumber.CompareNumbers;
import static lotto.domain.MakeNumber.MakeRandom;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Input;
import lotto.domain.MakeNumber;
import lotto.domain.Output;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Ranking;

public class Application {
    private static Long price = 0L;
    private static int bonus_number = 0;
    private static List<Lotto> lottos = new ArrayList<>();
    private static Map<Ranking, Integer> result = new HashMap<>();
    public static void main(String[] args) {
        Output.PrintInputPrice();
        price = Input.InputPrice();
        MakeRandom(lottos, price);

        Output.PrintInputWinnerNumber();
        Lotto winner_lotto = new Lotto(Input.InputWinnerNumber());

        Output.PrintInputBonusNumber();
        bonus_number = Input.InputBonusNumber(winner_lotto.getNumbers());

        result = CompareNumbers(lottos, winner_lotto, bonus_number);
        Output.PrintResult(result);

        CalEarn(result, price);
    }
}
