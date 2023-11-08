package lotto;

import java.util.Collections;
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

    // TODO: 추가 기능 구현
    public void printInfo(){
        System.out.println(numbers);
    }

    public int compareOther(Lotto other){
        List<Integer> res_com = this.numbers;
        res_com.retainAll(other.numbers);
        System.out.println(res_com.toString());
        return res_com.size();
    }

    public boolean containNum(int contain_num){
        return this.numbers.contains(contain_num);
    }

}