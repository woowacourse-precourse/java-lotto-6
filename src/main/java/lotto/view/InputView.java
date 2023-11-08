package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class InputView {
    public int inputPrice() {
        String input = Console.readLine();

        while (!validatePrice(input)) {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    private boolean validatePrice(String input) {
        try {
            int price = Integer.parseInt(input);
            checkDividedByThousand(price);
            return true;
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
        } catch (IllegalArgumentException ie) {
            System.out.println("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
        return false;
    }

    private void checkDividedByThousand(int price) throws IllegalArgumentException {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> inputWinNumbers() {
        String input = Console.readLine().replace(" ", "");

        while (!validateWinNumbers(input)) {
            input = Console.readLine().replace(" ", "");
        }

        return Stream.of(input.split(",")).mapToInt(Integer::parseInt).boxed().toList();
    }

    private boolean validateWinNumbers(String input) {
        String[] inputs;
        try {
            inputs = input.split(",");
            checkInputFormat(input);
            checkDuplicateNumber(inputs);
            checkSixNumbers(inputs);
            for (String number : inputs) {
                checkNumberInRange(number);
            }
        } catch (IllegalArgumentException ie) {
            System.out.println("[ERROR] 당첨 번호는 6개의 1부터 45까지 중복되지 않는 숫자입니다.");
            return false;
        }
        return true;
    }

    private void checkInputFormat(String input) throws IllegalArgumentException {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberInRange(String input) throws IllegalArgumentException {
        try {
            int number = Integer.parseInt(input);
            checkRange(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(int number) throws IllegalArgumentException {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(String[] inputs) throws IllegalArgumentException {
        Set<String> set = new HashSet<>(Arrays.asList(inputs));
        if (set.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSixNumbers(String[] inputs) throws IllegalArgumentException {
        if (inputs.length != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int inputBonusNumber(List<Integer> winNumbers) {
        String input = Console.readLine().replace(" ", "");

        while (!validateBonusNumber(winNumbers, input)) {
            input = Console.readLine().replace(" ", "");
        }

        return Integer.parseInt(input);
    }

    private boolean validateBonusNumber(List<Integer> winNumbers, String bonusNumber) {
        try {
            checkNumberInRange(bonusNumber);
            checkDuplicatedBonusNumber(winNumbers,bonusNumber);
        } catch (IllegalArgumentException ie) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45까지 당첨 번호와 중복되지 않는 숫자입니다.");
            return false;
        }
        return true;
    }

    private void checkDuplicatedBonusNumber(List<Integer> winNumbers, String bonusNumber) throws IllegalArgumentException {
        if (winNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException();
        }
    }
}
