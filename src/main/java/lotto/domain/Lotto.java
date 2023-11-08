package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ExceptionMessage;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicationValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto getRandomNumLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto randomNumLotto = new Lotto(numbers);
        return  randomNumLotto;
    }

    private void duplicationValidate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.duplicationError.getErrorMessage());
        }
    }
}
