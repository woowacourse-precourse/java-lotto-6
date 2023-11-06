package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.InputValidation;

public class InputView {
    private static final String DELIMITER = ",";
    private final InputValidation inputValidation = new InputValidation();

    public int purchaseCost() {
        while(true) {
            try {
                String purchaseCost = Console.readLine();
                inputValidation.validatePurchaseCost(purchaseCost);
                return Integer.parseInt(purchaseCost);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> winningNumber() {
        while(true) {
            try {
                String winningNumber = Console.readLine();
                inputValidation.validateWinningNumber(winningNumber);
                return Arrays.stream(winningNumber.split(DELIMITER)).map(Integer::valueOf).collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
