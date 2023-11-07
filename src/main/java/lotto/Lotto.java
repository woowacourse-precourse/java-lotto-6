package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numberLengthvaildation(numbers)) {
            throw new IllegalArgumentException("\n[ERROR]로또 번호는 6개 숫자여야 합니다.");
        }
        else if (numberSizeVaildation(numbers)){
            throw new IllegalArgumentException("\n[ERROR]로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        else if (numberDuplecateVaildation(numbers)){
            throw new IllegalArgumentException("\n[ERROR]로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private boolean numberLengthvaildation(List<Integer> numbers){
        if(numbers.size() != 6){
            return true;
        }
        return false;
    }

    private boolean numberSizeVaildation(List<Integer> numbers){
        for(int num : numbers){
            if(num > 45 || num < 1){
                return true;
            }
        }
        return false;
    }

    private boolean numberDuplecateVaildation(List<Integer> numbers){
        Set<Integer> numberset = new HashSet<>(numbers);
        int numbersize = numberset.size();
        if(numbersize != numbers.size()){
            return true;
        }
        return false;
    }
    
    public List<Integer> getLotto(){
        return numbers;
    }
}
