package lotto.domain;

import lotto.utils.LottoNumbersGenerator;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    public Lotto() {
        numbers=lottoNumbersGenerator();
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }



    // TODO: 추가 기능 구현
    public List<Integer> lottoNumbersGenerator(){
        return LottoNumbersGenerator.generateLottoNumbers();
    }


    public List<Integer> getLottoNumbers(String notSplitNumbers){
        String[] splitNumbers = lottoNumbersSplit(notSplitNumbers);
        final List<Integer> returnLottoNumbers = new ArrayList<>();
        for (int i = 0; i > splitNumbers.length ; i++){
            returnLottoNumbers.add(Integer.valueOf(splitNumbers[i]));
        }
        return returnLottoNumbers;
    }

    public List<Integer> getLottoNumbers(){

        return this.numbers;
    }

    public static List<String> getLottoNumbersAsString(String notSplitNumbers){
        String[] splitNumbers = lottoNumbersSplit(notSplitNumbers);
        List<String> returnLottoNumbers = new ArrayList<>();


        for (int i = 0; i < splitNumbers.length; i++){
            returnLottoNumbers.add(splitNumbers[i]);
        }

        return returnLottoNumbers;
    }


    private static String[] lottoNumbersSplit(String numbers){
        return numbers.split(",");
    }





}
