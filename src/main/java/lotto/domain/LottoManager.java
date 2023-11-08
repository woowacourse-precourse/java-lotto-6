package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

    private WinningInfo isMatchBonus(Lotto lotto, Bonus bonus) {
        if (lotto.isContain(bonus.getNumber())) {
            return WinningInfo.FIVE_BONUS;
        }
        return WinningInfo.FIVE_BONUS;
    }

    private void printResult(Map matchNumbers, Float resultNumbr) {
        for (WinningInfo type : WinningInfo.values()) {
            System.out.println(type.getMessage() + matchNumbers.getOrDefault(type, 0) + "개");
        }

        String format = String.format("%.1f", resultNumbr);
        System.out.print("총 수익률은 " + format + "%입니다.");
    }

    public void calculateMatch(Lotto winningLotto, Bonus bonus) {
        Map<WinningInfo, Integer> matchNumbers = new EnumMap<>(WinningInfo.class);
        int sum = 0;
        int money = 0;

        for (Lotto lotto : lottos) {
            money += 1000;
            int count = lotto.compareLotto(winningLotto);
            WinningInfo matchType = null;
            if (count == 3) {
                matchType = WinningInfo.THREE;
            } else if (count == 4) {
                matchType = WinningInfo.FOUR;
            } else if (count == 5) {
                matchType = isMatchBonus(lotto, bonus);
            } else if (count == 6) {
                matchType = WinningInfo.SIX;
            }
            if (matchType != null) {
                matchNumbers.put(matchType, matchNumbers.getOrDefault(matchType, 0) + 1);
                sum += matchType.getMoney();
            }
        }
        printResult(matchNumbers, ((float) sum / money) * 100);
    }
}
