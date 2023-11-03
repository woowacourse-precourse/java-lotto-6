package lotto.domain;

import lotto.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int money;
    private List<Lotto> lottos = new ArrayList<>();

    public Player(int money) {
        this.money = money;
    }

    public void issueLotto() {
        int lottoSize = money / 1_000;
        // TODO : lottos 사이즈와 lottoSize 비교
        for (int i = 0; i < lottoSize; i++) {
            lottos.add(new Lotto(RandomGenerator.generate()));
        }
    }

    public String issuedLottos() {
        StringBuilder result = new StringBuilder(lottos.size()).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            // TODO : lotto 번호 오름차순 정렬
            result.append(lotto.toString()).append('\n');
        }
        return result.toString();
    }

    public String lottoResults(List<Integer> winningNumbers, int bonusNumber) {
        return "";
    }
}
