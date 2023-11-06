package lotto.domain;


public class LottoAnswer extends Lotto {

    public LottoAnswer(String input) {
        parseInteger(input);
        validate(numbers);
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
}
