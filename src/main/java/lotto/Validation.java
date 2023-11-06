package lotto;

public class Validation {
    public boolean isIn1to45(int number){
        if (!(number >= 0 && number <=45)){
            throw new IllegalArgumentException("보너스 숫자가 1에서 45사이의 수가 아닙니다.");
        }
        return true;
    }
}
