package lotto.View;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static lotto.constant.OutputMessage.*;

public class OutputView {
    public static void printIssuedLottoNumbers(List<Integer> numbers){
        System.out.print("[");
        String result = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.print(result);
        System.out.println("]");
    }

    public static void printAmount(int Amount){
        System.out.printf(AMOUNT_COUNT.getMessage(), Amount);
    }

    public static void pirntWinningStatistics(Map<Integer, Integer> countOfWinning){
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.printf(FIFTH_PRIZE.getMessage(), countOfWinning.get(3));
        System.out.printf(FOURTH_PRIZE.getMessage(), countOfWinning.get(4));
        System.out.printf(THIRD_PRIZE.getMessage(), countOfWinning.get(5));
        System.out.printf(SECOND_PRIZE.getMessage(), countOfWinning.get(50));
        System.out.printf(FIRST_PRIZE.getMessage(), countOfWinning.get(6));
    }


    public static void printYield(String Yield){
        System.out.printf(LOTTO_YIELD.getMessage(), Yield);
    }
}
