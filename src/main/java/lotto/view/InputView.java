package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputView {

    // 구입 금액을 입력받는 메서드
    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력하세요 (1,000원 단위): ");
                int purchaseAmount = Integer.parseInt(Console.readLine());

                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
                }

                return purchaseAmount;
            } catch (NumberFormatException e) {
                handleError("올바른 숫자 형식이 아닙니다.");
            } catch (IllegalArgumentException e) {
                handleError(e.getMessage());
            }
        }
    }

    // 당첨 번호를 입력받는 메서드
    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력하세요 (1부터 45까지의 숫자 중복없이 콤마(,)로 구분): ");
                String input = Console.readLine();
                List<Integer> numbers = parseInputNumbers(input);

                if (numbers.size() != 6) {
                    throw new IllegalArgumentException("6개의 당첨 번호를 입력해야 합니다.");
                }

                return numbers;
            } catch (IllegalArgumentException e) {
                handleError(e.getMessage());
            }
        }
    }

    // 보너스 볼을 입력받는 메서드
    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 볼을 입력하세요 (1부터 45까지의 숫자): ");
                int bonusNumber = Integer.parseInt(Console.readLine());

                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("보너스 볼은 1부터 45 사이의 숫자여야 합니다.");
                }

                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복되면 안됩니다.");
                }

                return bonusNumber;
            } catch (NumberFormatException e) {
                handleError("올바른 숫자 형식이 아닙니다.");
            } catch (IllegalArgumentException e) {
                handleError(e.getMessage());
            }
        }
    }

    // 입력된 숫자 중 중복을 검사하는 메서드
    private List<Integer> parseInputNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] inputArray = input.split(",");
            for (String num : inputArray) {
                int number = Integer.parseInt(num.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("당첨 번호는 1부터 45까지의 숫자여야 합니다.");
                }
                numbers.add(number);
            }
            if (hasDuplicates(numbers)) {
                throw new IllegalArgumentException("당첨 번호는 중복되면 안됩니다.");
            }
        } catch (NumberFormatException e) {
            handleError("올바른 숫자 형식이 아닙니다.");
        }
        return numbers;
    }

    // 중복된 숫자가 있는지 확인하는 메서드
    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != new ArrayList<>(new HashSet<>(numbers)).size();
    }

    // 에러를 처리하는 메서드
    private void handleError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
