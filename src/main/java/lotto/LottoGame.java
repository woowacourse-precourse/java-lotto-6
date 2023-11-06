package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGame {
    // 로또 발행
    public int buyLotto(int amount) {
        int draws = amount/1000;
        System.out.println(draws+"개를 구매했습니다.");
        return draws;
    }

    // 당첨 번호 추첨
    public Lotto drawLotto(){
        // [8, 21, 23, 41, 42, 43]
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println(numbers);
        return new Lotto(numbers);
    }

    // 당첨 번호 + 보너스 번호 입력
    // 당첨 내역 출력
    // 수익률 출력
    // 예외 상황 출력
}
