package lotto.Input;

import com.sun.jdi.request.DuplicateRequestException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateException(numbers);
        rangeException(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력하셔야 합니다.");
        }
    }

    public void duplicateException(List<Integer> lotto) {
        if (lotto.size() == 6 & lotto.stream().distinct().count() != 6)
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
    }

    public void rangeException(List<Integer> lotto) {
        if (lotto.stream().filter(s -> s < 1 || s > 45).count() != 0)
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
    }


    // TODO: 추가 기능 구현
}
