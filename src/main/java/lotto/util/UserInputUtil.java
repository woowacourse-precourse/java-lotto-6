package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.validator.InputValidateService;
import lotto.view.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputUtil {


    public int readPurchaseAmount() {

        while (true) {
            try {
                int purchaseAmount = Integer.parseInt(Console.readLine());
                InputValidateService.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_PURCHASE_AMOUNT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }


    public List<Integer> readWinningNumbers() {
        while (true) {
            try {
                String winningNumbersLine = Console.readLine();
                List<Integer> winningNumbers = parseNumbers(winningNumbersLine);
                InputValidateService.validateNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private List<Integer> parseNumbers(String line) {
        try {
            List<Integer> numbers = Arrays.stream(line.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }


    public int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                InputValidateService.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
    }
    
}