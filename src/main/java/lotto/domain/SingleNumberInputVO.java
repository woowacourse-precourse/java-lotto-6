package lotto.domain;

public class SingleNumberInputVO {
    private int number;

    public SingleNumberInputVO(String number) {
        this.number = convertToIntegerIfValid(number);
    }

    public int getParsingNumber() {
        return number;
    }

    private int convertToIntegerIfValid(String input) {
        checkNullOrEmpty(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private void checkNullOrEmpty(String input) {
        if (input == null || input.replaceAll("\\s","").length() == 0) {
            throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
        }
    }

}
