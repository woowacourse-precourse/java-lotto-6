package lotto.model;

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
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int index = 0; index < numbers.size(); index++){
            sb.append(numbers.get(index));
            if(index != numbers.size()-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
