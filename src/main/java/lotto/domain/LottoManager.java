package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoManager {
    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    private List<Integer> generateUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto createLotto() {
        Lotto lotto = new Lotto(generateUniqueRandomNumber());
        return lotto;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public void renderAllLotte() {
        for (Lotto lotto : lottos) {
            lotto.showLottoNumber();
        }
    }

    public void calculateMatch(Lotto winningLotto, Bonus bonus) {
        final String threeMatchMessage = "3개 일치 (5,000원) - ";
        final Integer threeMatchMoney = 5000;
        final String fourMatchMessage = "4개 일치 (50,000원) - ";
        final Integer fourMatchMoney = 50000;
        final String fiveMatchMessage = "5개 일치 (1,500,000원) - ";
        final Integer fiveMatchMoney = 1500000;
        final String fiveBonusMatchMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        final Integer fiveBonusMatchMoney = 30000000;
        final String sixMatchMessage = "6개 일치 (2,000,000,000원) - ";
        final Integer sixMatchMoney = 2000000000;

        HashMap<Integer, Integer> matchNumbers = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            matchNumbers.put(i, 0);
        }
        int count = 0;
        int money = 0;
        int sum = 0;

        for (Lotto lotto : lottos) {
            money += 1000;
            for (int i = 0; i < 6; i++) {
                count = lotto.compareLotto(winningLotto);
            }
            // 분리 로직
            if (count == 3) {
                matchNumbers.put(5, matchNumbers.getOrDefault(3, 0) + 1);
                sum += threeMatchMoney;
            } else if (count == 4) {
                matchNumbers.put(4, matchNumbers.getOrDefault(4, 0) + 1);
                sum += fourMatchMoney;
            } else if (count == 5) {
                if (lotto.isContain(bonus.getNumber())) {
                    matchNumbers.put(2, matchNumbers.getOrDefault(2, 0) + 1);
                    sum += fiveBonusMatchMoney;
                    continue;
                }
                sum += fiveMatchMoney;
                matchNumbers.put(3, matchNumbers.getOrDefault(3, 0) + 1);
            } else if (count == 6) {
                sum += sixMatchMoney;
                matchNumbers.put(1, matchNumbers.getOrDefault(1, 0) + 1);
            }
        }

        System.out.println(threeMatchMessage + matchNumbers.get(5) + "개");
        System.out.println(fourMatchMessage + matchNumbers.get(4) + "개");
        System.out.println(fiveMatchMessage + matchNumbers.get(3) + "개");
        System.out.println(fiveBonusMatchMessage + matchNumbers.get(2) + "개");
        System.out.println(sixMatchMessage + matchNumbers.get(1) + "개");

        for (Integer key : matchNumbers.keySet()) {
            sum += matchNumbers.get(key);
        }
        String format = String.format("%.1f", ((float) sum / money) * 100);
        System.out.print("총 수익률은 " + format + "%입니다.");

    }
}
