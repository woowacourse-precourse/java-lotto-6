package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.*;

public class Lotto {
    private final List<Integer> numbers;
    private static List<Integer> lottoNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("들어올 수 있는 숫자는 여섯 개 숫자 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void outputLottoNumber(){
        for (Integer number : numbers) {
            System.out.print(number + ", ");
        }
    }

}
