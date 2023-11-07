package Controller;

import java.util.Collections;
import java.util.List;
import java.util.HashSet;
enum ERROR_MESSAGE{
    DUPLICATION("[ERROR] 중복된 숫자를 입력하셨습니다. 다시 입력하세요"),
    OVER_INPUT("[ERROR] 숫자 많이 입력하셨습니다. 다시 입력하세요"),
    UNDER_INPUT("[ERROR] 숫자 적게 입력하셨습니다. 다시 입력하세요"),
    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_FORMAT("[ERROR] 1~45의 자연수를 입력해야합니다. 다시 입력하세요");
    private ERROR_MESSAGE(){

    }

    private ERROR_MESSAGE(String s) {
    }
}
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate1(numbers);

        this.numbers = numbers;
    }
    private List<Integer> validate1(List<Integer> numbers) {
        //로또 번호에 중복된 숫자가 있으면 예외가 발생한다.
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size()!=numbersSet.size()) {
            System.out.println(ERROR_MESSAGE.DUPLICATION);
            throw new IllegalArgumentException();
        }
        return validate2(numbers);
    }
    private List<Integer> validate2(List<Integer> numbers) {
        //로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.
        if (numbers.size() > 6) {
            System.out.println(ERROR_MESSAGE.OVER_INPUT);
            throw new IllegalArgumentException();
        }
        return validate3(numbers);
    }
    private List<Integer> validate3(List<Integer> numbers) {
        //로또 번호의 개수가 5개가 이하면 예외가 발생한다.
        if (numbers.size() < 6) {
            System.out.println(ERROR_MESSAGE.UNDER_INPUT);
            throw new IllegalArgumentException();
        }
        return validate4(numbers);
    }
    private List<Integer> validate4(List<Integer> numbers) {
        //로또 각 번호가 1~45 이외이면 예외가 발생한다.
        if (Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            System.out.println(ERROR_MESSAGE.INVALID_RANGE);
            throw new IllegalArgumentException();
        }
        return numbers;
    }
}
