package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readPurchaseAmount() {
        while (true) {
            try {
                System.out.print("구입금액을 입력해 주세요: ");
                String input = Console.readLine();
                int purchaseAmount = Integer.parseInt(input);
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
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
        String[] inputWinningNumbers = Console.readLine().split(",");
        return checkWinningNumbersValidity(inputWinningNumbers);
    }

    private List<Integer> checkWinningNumbersValidity(String[] inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
