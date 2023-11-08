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
        int purchaseAmount;
        while (true) {
            System.out.println("\n구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount % LOTTO_PRICE != 0 || purchaseAmount < 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 하고 0보다 커야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
    }

    public List<Integer> getWinnigNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            String input = Console.readLine();

            try {
                if (!input.matches("^(\\d+,)*\\d+$")) {
                    throw new IllegalArgumentException("[ERROR] 숫자와 쉼표(,)로만 입력해야 합니다.");
                }

                winningNumbers = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .distinct() // 중복제거
                        .collect(Collectors.toList());

                if (winningNumbers.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 하고 중복이 없어야 합니다.");
                }

                for (int number : winningNumbers) {
                    if (number < MIN_NUMBER || number > MAX_NUMBER) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");

            String input = Console.readLine();

            try {
                bonusNumber = Integer.parseInt(input);
                if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }
}
