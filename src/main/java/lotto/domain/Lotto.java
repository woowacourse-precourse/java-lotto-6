package lotto.domain;

import lotto.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        validate(numbers);
        lottoNumbersSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        long removeDuplicationNumbersSize = numbers.stream().distinct().count();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoException.LOTTO_NUMBER_NOT_SIX_DIGITS.getMessage());
        }

        if(removeDuplicationNumbersSize != numbers.size()){
            throw new IllegalArgumentException(LottoException.LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers (){
        return this.numbers;
    }

    private void lottoNumbersSort(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public void lottoNumberDisplay(){
        List<Integer> lottoNumbers = getNumbers();

        StringJoiner displayLottoNumber = new StringJoiner(", ","[","]");
        for(int i = 0 ; i < lottoNumbers.size() ; i ++){
            String number = String.valueOf(lottoNumbers.get(i));
            displayLottoNumber.add(number);
        }
        System.out.println(displayLottoNumber);
    }
}
