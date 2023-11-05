package lotto.domain;

import java.util.List;

public class LottoBonus {
    private int number;

    public LottoBonus(List<Integer> numbers, int number){
        validate(numbers, number);
        this.number = number;
    }

    public void validate(List<Integer> numbers, int number){
        if(numbers.contains(number)){
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 번호와 중복되는 당첨 번호가 있습니다.");
        }
    }
}
