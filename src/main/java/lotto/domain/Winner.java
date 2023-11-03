package lotto.domain;

import java.util.List;

public class Winner {
    private List<Integer> numbers;

    private Integer bonusNumber;

    public Winner(List<Integer> numbers, Integer bonusNumber){
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public Integer getBonusNumber(){
        return bonusNumber;
    }
}
