package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void inputSeedMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int seedMoney = Integer.parseInt(readLine());
        if(seedMoney % 1000 != 0) {
            throw new ArithmeticException("1,000원 단위로 입력해주세요.");
        }
        System.out.println(seedMoney%1000 + "개를 구매했습니다.");
    }



}
