package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static java.util.Collections.*;

public class LottoPick {
    private final List<Integer>[] numbers;
    private int attempt;

    public LottoPick(int attempt) {
        vaildate(attempt);
        vaildateAmniotic(attempt);
        this.attempt = attempt / 1000;
        numbers = new List[this.attempt];
    }

    // 로또 번호 넘기기.
    public List<Integer>[] lottoPickNumber() {
        return numbers;
    }

    // 랜덤 6자리 숫자 배열
    public void makeLottoPick() {
        for (int i = 0; i < attempt; i++) {
            numbers[i] = randomCreate();
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
    private void vaildate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000단위로 나누어 져야 합니다.");
        }
    }

    private void vaildateAmniotic(int money){
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
    }

    // 랜덤 숫자 생성 (1~45 6개).
    private List<Integer> randomCreate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().toList();
    }
}
