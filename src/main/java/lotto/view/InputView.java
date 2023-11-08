package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.Validator;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해주세요.";
    private static final String HASH = ",";
    private final Validator validator = new Validator();

    public long getPurchaseAmount() {
        long purchaseAmount = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println(PURCHASE_AMOUNT_INPUT);
                String inputString = Console.readLine();
                purchaseAmount = validator.validateString(inputString);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }


    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println(WINNING_NUMBERS_INPUT);
                winningNumbers = splitWinningNumbersString(Console.readLine());
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = null;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println(BONUS_NUMBER_INPUT);
                inputBonusNumber = Console.readLine();
                validator.validateBonusNumbers(winningNumbers, inputBonusNumber);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(inputBonusNumber);
    }

    public List<Integer> splitWinningNumbersString(String winningNumbersString) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersString.split(HASH))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
        Validator.validateLottoNumbers(winningNumbers);
        return winningNumbers;
    }

}
