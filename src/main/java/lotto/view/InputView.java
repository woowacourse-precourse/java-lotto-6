package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {
    public int inputPrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");

            try {
                int inputPrice = parseInputNumber(Console.readLine());
                validatePurchaseAbility(inputPrice);
                return inputPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAbility(int inputPrince) {
        if (inputPrince < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액이 부족하여 로또를 살 수 없습니다.");
        }
    }

    public Lotto getWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            try {
                List<Integer> inputWinningNumbers = inputWinningNumbers();
                return new Lotto(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(number -> parseInputNumber(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] (,)를 기준으로 입력해주세요.");
        }
    }

    public int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");

            try {
                int inputBonusNumber = parseInputNumber(Console.readLine());
                duplicationBonusNumber(winningNumbers.getNumbers(), inputBonusNumber);
                return inputBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseInputNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 입력 번호는 숫자로 이루어져야 합니다.");
        }
    }

    private void duplicationBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

}
