package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidation(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input){
        this.numbers = WinningNumbers(input);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateValidation(List<Integer> numbers) {
        Set<Integer> removeDuplicationNumber = new HashSet<>(numbers);
        if(removeDuplicationNumber.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    public Lotto getPuschaseLotto() {
        return this;
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private List<Integer> WinningNumbers(String input) {
        String[] splitNumbers = input.replace(" ","").split(",");
        List<Integer> lottoNumbers = changeIntegerNumber(splitNumbers);
        sortNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> changeIntegerNumber(String[] splitNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int attempt = 0; attempt < splitNumbers.length; attempt++){
            lottoNumbers.add(Integer.parseInt(splitNumbers[attempt]));
        }
        return lottoNumbers;
    }
}
