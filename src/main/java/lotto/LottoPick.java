package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class LottoPick {
    private final List<Integer>[] numbers;
    private int attempt;

    public LottoPick(int attempt) {
        validate(attempt);
        this.attempt = attempt/1000;
        numbers = new List[this.attempt];
    }


    public void makeLottoPick() {
        for(int i = 0; i < attempt; i++) {
            numbers[i] = randomCreate();
        }
        for(int i = 0; i < attempt; i++){
            numbers[i].sort(Comparator.naturalOrder());
        }
    }

    public void outputLottoPick(){
        System.out.println(Arrays.toString(numbers));
    }

    // 금액 확인.
    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000단위로 나누어 져야 합니다.");
        }
    }

    // 랜덤 숫자 생성.
    private List<Integer> randomCreate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
