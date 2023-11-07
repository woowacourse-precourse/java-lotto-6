package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void addBonusNumber(int bonusNumber){
        numbers.add(bonusNumber);
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    public int getBonusNumber(){
        return numbers.get(6);
    }

    // TODO: 추가 기능 구현
}
