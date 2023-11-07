package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    private String input;
    private List<String> winningNumbers;

    public int purchasePrice() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readPurchasePrice();
                isValid = validatePurchasePriceFormat();

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }

        return getLottoTicketsNumber();
    }

    public void winningNumbers() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readWinningNumbers();
                isValid = validateWinningNumbers();

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }
    }


    private void readPurchasePrice() {
        System.out.print("구입 금액을 입력해 주세요.\n");
        this.input = Console.readLine().trim();
    }

    private void readWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요.\n");
        this.input = Console.readLine().trim();

        this.winningNumbers = List.of(this.input.split(","));
    }

    private boolean validatePurchasePriceFormat() {
        if (!this.input.matches("^(\\d+000)$")) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력받으며 1,000원으로 나누어떨어져야 합니다.\n");
        }

        return true;
    }

    private boolean validateWinningNumbers() {
        validateWinningNumbersCount();
        validateWinningNumbersFormat();
        validateWinningNumbersDuplicate();

        return true;
    }

    private void validateWinningNumbersCount() {
        if (this.winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 쉼표(,)를 기준으로 6개여야 합니다.\n");
        }
    }

    private void validateWinningNumbersFormat() {
        for (String number : this.winningNumbers) {
            if (!number.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
            }
        }
    }

    private void validateWinningNumbersDuplicate() {
        Set<String> noDuplicateNumbers = new HashSet<>(this.winningNumbers);

        if (noDuplicateNumbers.size() != this.winningNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 숫자 6개여야 합니다.\n");
        }
    }

    private int getLottoTicketsNumber() {
        return Integer.parseInt(this.input) / 1000;
    }
}
