package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers){
        for(int number: numbers){
            if(number<1 || number>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public int countMatchedNumbers(Lotto lotto){
        int count = 0;
        for(int number: numbers){
            if(lotto.getNumbers().contains(number)){
                count++;
            }
        }
        return count;
    }

    public boolean isBonusMatched(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
