package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String toString(){
        String lottoNumber = String.join(", ", String.valueOf(numbers));
        return lottoNumber;
    }

    public int[] toIntegerArr(){
        int[] lottoNumber = new int[6];
        for(int i=0;i<numbers.size();i++){
            lottoNumber[i] = numbers.get(i);
        }
        return lottoNumber;
    }
    // TODO: 추가 기능 구현
}
