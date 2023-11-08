package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Util.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.Util.LottoEnum.LOTTO_PRICE;
import static lotto.Util.ViewConstant.*;

public class InputView {
    private String inputPreprocessing() {
        String input = Console.readLine();

        Validation.emptyCheck(input);
        Validation.numberCheck(input);

        return input;
    }

    private int[] convertIntArr() {
        String input = inputPreprocessing();
        input = input.replace(BLACK, BLACKNESS);

        return Stream.of(input.split(COMMA))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public List<Integer> getWinnerNumbers() {
        System.out.printf(WINNING_NUMBER);
        int[] preprocessedNumbers = convertIntArr();
        for (int number : preprocessedNumbers) {
            Validation.rangeCheck(number);
        }

        List<Integer> winnerNumbers = Arrays.stream(preprocessedNumbers)
                .boxed()
                .collect(Collectors.toList());

        Validation.lackInputCheck(winnerNumbers);

        return winnerNumbers;
    }

    public int getBonusNumber() {
        System.out.printf(BONUS_NUMBER);
        String input = inputPreprocessing();

        int bonusNumber = Integer.parseInt(input);

        Validation.rangeCheck(bonusNumber);

        return bonusNumber;
    }

    public int getPurchaseAmount() {
        System.out.printf(COST);
        int amount = 0;

        String input = inputPreprocessing();
        Validation.parseIntCheck(input);

        int cost = Integer.parseInt(input);
        Validation.banknoteCheck(cost);

        amount = cost / LOTTO_PRICE.getValue();
        System.out.printf(AMOUNT, amount);

        return amount;
    }
}
