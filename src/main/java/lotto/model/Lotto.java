package lotto.model;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

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
        if (numbers.size() != LottoConstant.LENGTH.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_LENGTH.getMessage());
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < LottoConstant.START.getNumber() || num > LottoConstant.END.getNumber()) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validatePattern(String numbers){
        if(!Pattern.matches("^[1-9|,]+$",numbers)){
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_ONLY_LOTTO.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers){
        for(int i = 0; i< numbers.size()-1; i++){
            for (int j = i+1; j< numbers.size(); j++){
                isCheckDupicateNumber(numbers.get(i),numbers.get(j));
            }
        }
    }

    private void isCheckDupicateNumber(Integer num,Integer num2){
        if(num.equals(num2)){
            throw new IllegalArgumentException(ExceptionMessage.DUPICATE_NUMBER.getMessage());
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
