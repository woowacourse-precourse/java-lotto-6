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
        this.attempt = attempt / 1000;
        numbers = new List[this.attempt];
    }

    // 로또 번호 넘기기.
    public List<Integer>[] lottoPickNumber(){
        return numbers;
    }

    // 랜덤 6자리 숫자 배열 후 오름차순 정리
    public void makeLottoPick() {
        for (int i = 0; i < attempt; i++) {
            numbers[i] = randomCreate();
//            numbers[i].sort(Comparator.naturalOrder());
        }
    }

    // 로또 값 출력.
    public void outputLottoPick() {
        System.out.println("\n" + attempt + "개를 구매했습니다.");
        for (int i = 0; i < attempt; i++) {
            System.out.println(numbers[i]);
        }
    }

    // 금액 입증 확인.
    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000단위로 나누어 져야 합니다.");
        }
    }

    // 랜덤 숫자 생성 (1~45 6개).
    private List<Integer> randomCreate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
