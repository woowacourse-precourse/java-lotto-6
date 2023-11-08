package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public int promptForPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine().trim());
                if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위의 양수로 입력해야 합니다.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 금액입니다. 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> promptForWinningNumbers() {
        while (true) {
            try {
                System.out.println("로또 번호를 입력해 주세요.");
                String input = Console.readLine().trim();
                List<Integer> winningNumbers = LottoUtils.convertStringToLottoNumberList(input);
                validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> numbersSet = new HashSet<>(winningNumbers);
        if (numbersSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public int promptForBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
