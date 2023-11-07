package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int money;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
    }


    // TODO: 추가 기능 구현
}

