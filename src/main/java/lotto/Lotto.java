package lotto;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOutOfBound(numbers);
        checkDup(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers)throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void checkOutOfBound(List<Integer> numbers) throws IllegalArgumentException{
        for(int i=0; i<6; i++){
            if(1>numbers.get(i) || numbers.get(i)>45){
                throw new IllegalStateException();
            }
        }
    }
    public static void checkDup(List<Integer> numbers) throws IllegalCallerException{
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numbers.size() != numSet.size()){
            //중복 발생
            throw new IllegalCallerException();
        }
    }
    // TODO: 추가 기능 구현
}
