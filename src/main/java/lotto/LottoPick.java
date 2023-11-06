package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static java.util.Collections.*;

public class LottoPick {
    private final List<Integer>[] numbers;
    private int attempt;

    public LottoPick(int attempt) {
        validate(attempt);
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
//            Collections.sort(numbers[i]); // 콜렉션 정렬 사용시 기능 테스트에서 오류가 발생함.
        }
    }

    // 로또 값 출력.
    public void outputLottoPick() {
        System.out.println("\n" + attempt + "개를 구매했습니다.");
        for (int i = 0; i < attempt; i++) {
            System.out.println(sortResult(numbers[i]));
        }
    }

    //정렬시 기능 테스트에서 오류가 걸려 수동으로 정렬하기로 함.
    private String sortResult(List<Integer> arr) {
        String str = "[";
        for (int i = 1; i <= 45; i++) {
            for (Integer number : arr) {
                if (i == number) {
                    str += i;
                    str += ", ";
                }
            }
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
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
