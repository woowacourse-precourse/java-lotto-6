package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    enum ErrorMessage {
        SizeCheck("[ERROR] 로또 번호는 6자리 숫자여야 합니다."), rangeCheck("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."), duplicationCheck("[ERROR] 로또 번호는 중복 되지 않는 숫자로만 구성되어야 합니다.");
        private final String value;
        ErrorMessage(String value) {
            this.value = value;
        }
    }
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        if (validate(numbers)){ this.numbers = numbers; }
        else { this.numbers = null; }
    }
    public List<Integer> getter(){
        return numbers;
    }
    public boolean rangeCheck(List<Integer> numbers){
        for(int i:numbers){
            if(i > 45 || i < 1){ return true; }
        }
        return false;
    }
    public boolean duplicationCheck(List<Integer> numbers){
        Set<Integer> wnSet = new HashSet<>(numbers);
        return wnSet.size() != 6;
    }
    private boolean validate(List<Integer> numbers) {
        try{
            if (numbers.size() != 6) { throw new IllegalArgumentException(ErrorMessage.SizeCheck.value);}
            else if(rangeCheck(numbers)){ throw new IllegalArgumentException(ErrorMessage.rangeCheck.value);}
            else if(duplicationCheck(numbers)){ throw new IllegalArgumentException(ErrorMessage.duplicationCheck.value);}
            else { return true; }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
