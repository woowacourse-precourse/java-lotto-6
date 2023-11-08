package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.WinningNumbers;
import lotto.View.LottoView;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public int getPurchaseAmountFromInput(LottoView view) {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int purchaseAmount = Integer.parseInt(input);
                UserInputValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                view.displayError("[ERROR] 유효한 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                view.displayError(e.getMessage());
            }
        }
    }


    public WinningNumbers getWinningNumbersFromInput(LottoView view) {
        while (true) {
            try {
                List<Integer> winningNumbers = getWinningNumbers(view);
                int bonusNumber = getBonusNumber(view, winningNumbers);
                return new WinningNumbers(new Lotto(winningNumbers), bonusNumber);
            } catch (IllegalArgumentException e) {
                view.displayError(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers(LottoView view) {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumberInput = Console.readLine();
                return parseNumbers(winningNumberInput);
            } catch (NumberFormatException e) {
                view.displayError("[ERROR] 유효한 숫자를 입력해야 합니다.");
            }
        }
    }

    private int getBonusNumber(LottoView view, List<Integer> winningNumbers) throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        UserInputValidator.validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            UserInputValidator.validateLottoNumber(number);
            numbers.add(number);
        }
        UserInputValidator.validateLottoNumbers(numbers);
        return numbers;
    }

}
