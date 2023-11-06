package lotto;

public class Bonus {

    private int bonusNumber;

    public Bonus(int number){
        validate(number);
        this.bonusNumber = number;
    }

    private void validate(int number){
        isIn1to45(number);
    }

    private void isIn1to45(int number){
        if (!(number >= 0 && number <=45)){
            throw new IllegalArgumentException("보너스 숫자가 1에서 45사이의 수가 아닙니다.");
        }
    }
}
