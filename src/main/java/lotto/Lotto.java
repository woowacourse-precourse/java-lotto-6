package lotto;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private final int START = 1;
    private final int END = 45;

    public Lotto(){
        this.numbers = new ArrayList<>();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        validateDuplicateNumber(numbers);
        sortDesc(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers){
        validatePattern(numbers);
        List<Integer> num = toList(numbers);

        validate(num);
        validateNumber(num);
        validateDuplicateNumber(num);
        this.numbers = num;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < START || num > END) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validatePattern(String numbers){
        if(!Pattern.matches("^[1-9|,]+$",numbers)){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers){
        for(int i = 0; i< numbers.size()-1; i++){
            for (int j = i+1; j< numbers.size(); j++){
                if(numbers.get(i).equals(numbers.get(j))){
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static List<Integer> toList(String numbers){
        return Arrays.stream(numbers.split(","))
                .map(num -> Integer.parseInt(num)).toList();
    }

    private void sortDesc(List<Integer> numbers){
        numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d, %d, %d, %d, %d]",numbers.get(0),numbers.get(1),numbers.get(2),numbers.get(3),numbers.get(4),numbers.get(5));
    }
}
