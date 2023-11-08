package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6자리 입니다.");
        }
    }

    public static void validate(int money){
        try {
            money = money % 1000;
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야합니다.");
            Input.inputMoney();
        }
    }
    public List<Integer> setNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


}