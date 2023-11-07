package lotto.Model.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Common.LottoValue;

public class Lotto {
    private final List<Integer> numbers;

    /**
     * 랜덤수 를 통해 6자리 또로 1장 을 같고 있느 객체,
     *
     * @param numbers
     */

    public Lotto(List<Integer> numbers) {
        validateNumberDuplicate(numbers);
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNumberSorting(numbers);
        this.numbers = numbers;
    }


    //생성된 로또 번호가 6개가 아닐경우
    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoValue.LOTTO_COUNT_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    //수가 1~45 사인인지
    private void validateNumberRange(List<Integer> numbers){
        for( Integer number : numbers) {
            if(number < LottoValue.LOTTO_FIRST_NUMBER.getValue() || number > LottoValue.LOTTO_FINAL_NUMBER.getValue() ) {
                throw new IllegalArgumentException("");
            }
        }

    }

    //각 수에 중복이 없는지
    private void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().toList().size()
                != LottoValue.LOTTO_COUNT_NUMBER.getValue()) {
            throw new IllegalArgumentException("");
        }

    }

    //각 수가 오름 차순으로 정렬 되어 있는지 ?
    private void validateNumberSorting(List<Integer> numbers) {
        if (numbers.stream().distinct().sorted().toList().size()
                != LottoValue.LOTTO_COUNT_NUMBER.getValue()){
            throw new IllegalArgumentException("");
        }
    }



    public List<Integer> getNumbers(){
        return this.numbers;
    }


    // TODO: 추가 기능 구현


}
