package lotto;

public class LottoResult {

    private final int resultNumbers;
    private final int bonusNumber;

    public LottoResult(String input1, String input2) {
        this.resultNumbers = Integer.parseInt(input1);
        this.bonusNumber = Integer.parseInt(input2);
    }
}
