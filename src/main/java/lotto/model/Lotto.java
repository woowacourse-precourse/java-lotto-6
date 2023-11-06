package lotto.model;

import java.util.List;
import java.util.StringJoiner;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        long removeDuplicationNumbersSize = numbers.stream().distinct().count();

        if (removeDuplicationNumbersSize != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers (){
        return this.numbers;
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

    // TODO: 추가 기능 구현
}
