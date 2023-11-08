package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final int WINNING_NUMBER_SIZE = 6;

    private static void validateDuplicateWinningNumbers(String[] inputWinningNumbers) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(inputWinningNumbers));
        if (uniqueNames.size() != inputWinningNumbers.length) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력하세요.");
        }
    }

    private static void validateRangeWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 값이어야 합니다.");
        }
    }

    public int readPurchaseAmount() {
        while (true) {
            try {
                System.out.print("구입금액을 입력해 주세요: ");
                String input = Console.readLine();
                int purchaseAmount = Integer.parseInt(input);
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.print("당첨 번호를 입력해 주세요: ");
                String[] inputWinningNumbers = Console.readLine().split(",");
                return checkWinningNumbersValidity(inputWinningNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> checkWinningNumbersValidity(String[] inputWinningNumbers) {
        validateWinningNumbersLength(inputWinningNumbers);
        validateDuplicateWinningNumbers(inputWinningNumbers);
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateRangeWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public void validateWinningNumbersLength(String[] inputWinningNumbers) {
        if (inputWinningNumbers.length != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력하세요.");
        }
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.print("보너스 볼을 입력해 주세요: ");
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);
                checkBonusNumberValidity(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkBonusNumberValidity(int bonusNumber, List<Integer> winningNumbers) {
        validateRangeBonusNumber(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber, winningNumbers);
    }

    private void validateRangeBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 값이어야 합니다.");
        }
    }

    private void validateDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

}
