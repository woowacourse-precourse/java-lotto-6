package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.global.Validator;

public class Input {

    private String input;
    private List<String> winningNumbers;

    public int purchasePrice() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readPurchasePrice();
                isValid = Validator.purchasePriceFormat(this.input);

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
                isValid = Validator.lottoNumbersWithString(this.winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }
    }

    public void BonusNumber() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readBonusNumber();
                isValid = Validator.bonusNumber(this.input, this.winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }

        this.winningNumbers.add(this.input); // 당첨 번호에 보너스 번호도 추가
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void readPurchasePrice() {
        System.out.print("구입 금액을 입력해 주세요.\n");
        this.input = Console.readLine().trim();
    }

    private void readWinningNumbers() {
        System.out.print("\n당첨 번호를 입력해 주세요.\n");
        this.input = Console.readLine().trim();

        this.winningNumbers = new ArrayList<>(List.of(this.input.split(",")));
    }

    private void readBonusNumber() {
        System.out.print("\n보너스 번호를 입력해 주세요.\n");
        this.input = Console.readLine().trim();
    }

    private int getLottoTicketsNumber() {
        return Integer.parseInt(this.input) / 1000;
    }
}
