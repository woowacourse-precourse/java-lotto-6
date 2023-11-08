package lotto;
import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        validate(numbers);
        if(set.size() == 6)
            this.numbers = numbers;
        else
            throw new IllegalArgumentException();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public void numberPrint(){
        System.out.println(numbers);
    } //해당 객체에 저장된 리스트 출력

    public List<Integer> returnNumbers() {
        return numbers;
    } //해당 객체에 저장된 리스트를 리턴

}
