package lotto;

import static lotto.Application.LOTTO_NUMBER_COUNT;

import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        if(isDuplicated(numbers)) {
            throw new IllegalArgumentException("중복된 수를 로또 번호로 갖을 수 없습니다.");
        }
        if(numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개 자리입니다.");
        }
        this.numbers = numbers;
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        for(int i =0; i< numbers.size(); i++) {
            for(int j = i+1; j<numbers.size(); j++) {
                if(numbers.get(i).equals(numbers.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
