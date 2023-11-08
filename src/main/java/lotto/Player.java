package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private int count;
    private List<Lotto> playerlotto = new ArrayList<>();

    public List<Lotto> getPlayerlotto(int count) {
        this.count = count;

        while (playerlotto.size() < count) {
            Lotto playerLottoElement = new Lotto(setPlayerLottoNum());
            playerlotto.add(playerLottoElement);
        }

        printPlayerLottos();
        return playerlotto;
    }

    //플레이어 로또 숫자 랜덤 발행
    public List<Integer> setPlayerLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45,6);
    }

    public void printPlayerLottos() {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for(Lotto lotto :  playerlotto) {
            List<Integer> numbers = lotto.getLotto();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
}
