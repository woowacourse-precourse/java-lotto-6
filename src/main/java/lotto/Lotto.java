package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int NUM_OF_LOTTO =6;
    private static final String NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 "+NUM_OF_LOTTO+"개 입력 가능합니다.";
    private static final String OVERLAP_NUM_ERROR="[ERROR] 중복된 숫자가 존재합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_LOTTO) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    private void checkOverlap(List<Integer> numbers){
        Set<Integer> overlapCheck = new HashSet<>();
        for(int i=0; i<numbers.size(); i++)
        {
            overlapCheck.add(numbers.get(i));
        }
        if(overlapCheck.size()!=6){
            throw new IllegalArgumentException(OVERLAP_NUM_ERROR);
        }

    }

}
