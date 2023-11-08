package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("\n구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return validatePurchaseAmount(input);
            } catch(Exception e) {
                handleInputError(e);
            }
        }
    }

    private int validatePurchaseAmount(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % LOTTO_PRICE != 0 || purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 하고 0보다 커야 합니다.");
        }

        return purchaseAmount;
    }

    private void handleInputError(Exception e) {
        if (e instanceof NumberFormatException) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
        } else {
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> getWinnigNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                return validateWinnigNumbers(input);
            } catch (Exception e) {
                handleInputError(e);
            }
        }
    }

    private List<Integer> validateWinnigNumbers(String input) {
        String[] numberStrings = input.split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> winningNumbers = Arrays.stream(numberStrings).map(Integer::parseInt).distinct().collect(Collectors.toList());

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }

        for (int number : winningNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        return winningNumbers;
    }
    

    public int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return validateBonusNumber(input, winningNumbers);
            } catch(Exception e) {
                handleInputError(e);
            }
        }
    }

    private int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }
}