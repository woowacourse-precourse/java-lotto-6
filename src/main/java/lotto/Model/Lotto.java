package lotto.Model;

import java.util.Arrays;
import java.util.Iterator;
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
        if(!duplicationCheck(numbers))
            throw new IllegalArgumentException();
    }

    private boolean duplicationCheck(List<Integer> numbers){
        int[] cnt = new int[46];
        Arrays.fill(cnt, 0);

        boolean result = true;

        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()){
            cnt[it.next()]++;
        }

        for(int i = 1; i < cnt.length; i++)
            if(cnt[i] > 1){
                result = false;
                break;
            }

        return result;
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }
}
