package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoPick {
    private final List<Integer> numbers;
    private final int attempt;

    public LottoPick(List<Integer> numbers, int attempt) {
        this.numbers = numbers;
        this.attempt = attempt;
    }

    //횟수 받기.
    public int getMoney(int money) {


    }

    private void validate(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException("금액은 1000단위로 나누어 져야 합니다.");
        }
    }

    //
    private List<Integer> randomCreate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
