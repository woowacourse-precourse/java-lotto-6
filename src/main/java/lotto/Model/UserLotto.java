package lotto.Model;

import java.util.Iterator;
import java.util.List;

public class UserLotto {

    private final List<Integer> numbers;

    public UserLotto(List<Integer> numbers){
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        // 보너스 번호까지 포함
        if(numbers.size() != 7){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void printNumbers(){
        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }

}
