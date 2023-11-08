package lotto;

import lotto.util.Validator;

import java.util.*;

public class Lotto {
    public static final int SIZE = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int PRICE = 1000;
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumberListSorted(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateSize(numbers, SIZE);
        Validator.validateIfDuplicateExist(numbers);
    }
    public final String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i=0; i<numbers.size(); i++){
            sb.append(numbers.get(i));
            if(i != numbers.size()-1){
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
