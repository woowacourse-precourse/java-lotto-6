package lotto.Model;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 로또번호 생성하기
    public void printLottoNumber(){
        int i = 0;
        System.out.print("[");
        while( i == this.numbers.size()){
            System.out.print(numbers.get(i) + ", ");
            if(i == this.numbers.size()){
                continue;
            }
        }
        System.out.print("]");
    }
}
