package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Number.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
        List<Integer> temp = new ArrayList<>(numbers);
        for (int number : numbers) {
            temp.remove((Integer) number);
            if (temp.contains(number)) {
                throw new IllegalArgumentException();
            }
        }
    }
    // TODO: 추가 기능 구현
    public int match(List<Integer> winningNumbers){
        int result = 0;
        for (int number : winningNumbers){
            if (numbers.contains(number))
                result++;
        }
        return result;
    }
    public void lottoSort(){
        numbers.sort(Integer::compareTo);
    }
    public boolean matchBonus(int number){
        return numbers.contains(number);
    }

    public void printLotto(){
        System.out.println(numbers);
    }
}
