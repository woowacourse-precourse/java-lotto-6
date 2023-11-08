package lotto;

import java.sql.Connection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicationTest(numbers);
        wrongArgument(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    private void duplicationTest(List<Integer> numbers){
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(numbers);
        if(hashSet.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    private void wrongArgument(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45)
                throw new IllegalArgumentException();
        }
    }

    List<Integer> getNumbers(){
        return this.numbers;
    }

    void showNumbers(){
        System.out.print("[");
        for (int i = 0; i < this.numbers.size(); i++) {
            System.out.print(this.numbers.get(i));
            if (i < this.numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
