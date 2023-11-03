package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> winningNumbers = new ArrayList<Integer>();
    private int bonusNumber;
    private int purchaseAmount;


    public String getUserInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public void getPurchaseAmount() {
        String input = getUserInput("구입금액을 입력해 주세요.");
        validatePurchaseAmount(input);
    }

    public void getWinningNumbers() {
        String input = getUserInput("당첨 번호를 입력해 주세요.");
        splitWinningNumbers(input);
    }

    public void getBonusNumber() {
        String input = getUserInput("보너스 번호를 입력해 주세요.");
        this.bonusNumber = validateNumber(input);
    }

    private Integer validateNumber(String number) {
        try {
            Integer integerNumber = Integer.parseInt(number);
            return integerNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validatePurchaseAmount(String input) {
        this.purchaseAmount = validateNumber(input);
        if (this.purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위여야 합니다.");
        }

    }

    private void splitWinningNumbers(String input) {

        String[] numberStrings = input.split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("입력한 번호의 개수가 올바르지 않습니다.");
        }
        for (String number : numberStrings) {
            addNumber(validateNumber(number));
        }

    }

    private void addNumber(Integer number) {
        this.winningNumbers.add(number);
    }
}
