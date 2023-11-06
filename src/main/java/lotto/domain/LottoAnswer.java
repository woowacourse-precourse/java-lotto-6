package lotto.domain;


public class LottoAnswer extends Lotto {
    private BonusNumber bonusNumber;

    public LottoAnswer(String input) {
        parseInteger(input);
        validate(numbers);
    }

    public LottoAnswer(String input, int bonusNumber) {
        parseInteger(input);
        validate(numbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void parseInteger(String input) {
        String[] parts = input.split(",");

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 당첨 번호를 입력해주세요.");
            }
        }
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
