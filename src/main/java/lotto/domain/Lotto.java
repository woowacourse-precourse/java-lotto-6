package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Lotto {
    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size()!=6) {
            throw new IllegalArgumentException();
        }
    }
    
    public int readAmount() {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        String purchaseAmountText = readLine();
        int purchaseAmount = Integer.parseInt(purchaseAmountText);
        return purchaseAmount;
    }
}
