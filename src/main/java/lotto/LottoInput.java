package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoInput {

    private final int amount;

    public LottoInput(int amount) {
        checkPurchaseAmount(amount);
        this.amount = amount;
    }
    private void checkPurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    protected List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean isValid;

        do {
            String input = "1,2,3,4,5,6";
            isValid = parseAndValidateNumbers(input, winningNumbers);
        } while (!isValid);

        return winningNumbers;
    }

    private boolean parseAndValidateNumbers(String input, List<Integer> winningNumbers) {
        String[] numbers = input.split(",");
        try {
            List<Integer> parsedNumbers = parseNumbers(numbers);
            validateNumbers(parsedNumbers);
            winningNumbers.addAll(parsedNumbers);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private List<Integer> parseNumbers(String[] numbers) throws NumberFormatException {
        List<Integer> num = new ArrayList<>();
        for (String value : numbers) {
            int number = Integer.parseInt(value.trim());
            num.add(number);
        }
        return num;
    }

    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        new Lotto(numbers);
    }
}
