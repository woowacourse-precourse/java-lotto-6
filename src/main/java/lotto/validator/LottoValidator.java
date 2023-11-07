package lotto.validator;

import java.util.List;

public class LottoValidator {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR = "[ERROR]";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 로또 번호가 있습니다.";
    private static final String SIZE_OVER_MESSAGE = "로또 번호가 6개가 아닙니다.";
    private static final String RANGE_OVER_MESSAGE = "로또 번호가 1이상 45이하가 아닙니다.";
    private static final String NOT_SORT_MESSAGE = "로또가 오름차순이 아닙니다.";

    public LottoValidator(List<Integer> numbers){
        isSizeError(numbers);
        isRangeOver(numbers);
        isDuplicate(numbers);
        isSorted(numbers);
    }

    public void isSizeError(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR + SIZE_OVER_MESSAGE);
        }
    }

    public void isRangeOver(List<Integer> numbers) {
        for(Integer number : numbers){
            if (number>MAX_NUM || number<MIN_NUM){
                throw new IllegalArgumentException(ERROR + RANGE_OVER_MESSAGE);
            }
        }
    }

    public void isDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException(ERROR + DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void isSorted(List<Integer> numbers){
        for (int i = 0; i<numbers.size()-1; i++){
            if (numbers.get(i)>numbers.get(i+1)){
                throw new IllegalArgumentException(ERROR + NOT_SORT_MESSAGE);
            }
        }
    }
}
