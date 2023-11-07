package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Lotto {
    private final List<Integer> numbers;
    private final int START = 1;
    private final int END = 45;

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
        sortDesc(num);
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
        numbers.sort(Comparator.naturalOrder());
    }
}
