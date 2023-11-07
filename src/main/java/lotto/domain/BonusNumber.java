package lotto.domain;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public BonusNumber(String input) {
        int number = isNum(input);
        validate(number);
        this.number = number;

    }

    private void validate(int number) {
        isInRange(number);
    }

    private int isNum(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void isInRange(int number) {
        if (number < Lotto.MIN_VALUE || number > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException("보너스 번호는 1과 45사이의 수여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
