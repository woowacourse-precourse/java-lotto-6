package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoDrawMachine {
    private final String inputWinningNumberMessage = "당첨 번호를 입력해 주세요.";
    private final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningLotto drawWinningLotto() {
        System.out.println(inputWinningNumberMessage);
        inputWinningNumbers();

        System.out.println();
        System.out.println(inputBonusNumberMessage);
        inputBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void inputWinningNumbers() {
        while (true) {
            try {
                String userInput = Console.readLine();
                List<Integer> result = parseToIntegerList(userInput);
                validateWinningNumbers(result);
                winningNumbers = result;
                break;
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }

    private List<Integer> parseToIntegerList(String userInput) {
        List<Integer> result = new ArrayList<>();
        for (String number : userInput.split(",")) {
            if (number.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
            }
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    private void validateWinningNumbers(List<Integer> result) {
        LottoValidator.sizeValidate(result);
        LottoValidator.rangeValidateFromList(result);
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                String userInput = Console.readLine();
                bonusNumber = Integer.parseInt(userInput);
                validateBonusNumber();
                break;
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }

    private void validateBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
        }
        LottoValidator.rangeValidate(bonusNumber);
    }
}
