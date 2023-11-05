package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {

    private final int lottoCnt;   // 구입한 로또 개수

    public Play(int cost) {
        // 구매 금액이 1000원으로 나누어 떨어지지 않는 경우 예외 발생
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        // 구입한 로또 개수
        this.lottoCnt = cost / 1000;
    }

    List<Integer> getLottoNums() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public void startGame() {
        System.out.println(lottoCnt + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = getLottoNums();
            System.out.println(numbers);
            lottos.add(new Lotto(numbers));
        }
    }
}
