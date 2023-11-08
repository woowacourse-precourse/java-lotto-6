package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.Lottos;
import domain.Player;

import java.util.*;

public class LottoService {
    private Player player;
    private Lottos lottos = new Lottos();
    private static int BONUS_MATCH_NUMBER = 7;

    public List<Lotto> buyLotto(int input) {
        lottos = new Lottos();
        for (int i = 0; i < input; i++) {
            getLottoNumbers();
        }
        return lottos.getLottoList();
    }

    public int getTotalCount(int input) {
        return input / 1000;
    }

    private void getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> subList = new ArrayList<>();
        subList.addAll(numbers);
        Collections.sort(subList);
        lottos.addLotto(new Lotto(numbers));
    }

    public void setPlayer(List<Integer> winningNumbers, int bonusNumber, int money) {
        player = new Player(winningNumbers, bonusNumber, money);
    }

    public HashMap getWinningResult() {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        HashMap<Integer, Integer> moneyMap = new HashMap<>();
        setMoneyMap(moneyMap);
        for (Lotto lotto : lottos.getLottoList()) {
            int matchCount  = lotto.match(player.getWinningLotto().getLottoNumbers());
            resultMap.put(matchCount, resultMap.getOrDefault(matchCount, 0) + 1);
            player.earn(moneyMap.getOrDefault(matchCount, 0));
            if (matchCount == 5 && isBonusNumberMatch(lotto)) {
                resultMap.put(matchCount, resultMap.getOrDefault(matchCount, 0) - 1);
                resultMap.put(BONUS_MATCH_NUMBER, resultMap.getOrDefault(matchCount, 0) + 1);
                player.minus(moneyMap.get(matchCount));
                player.earn(moneyMap.get(BONUS_MATCH_NUMBER));
            }
        }
        return resultMap;
    }

    private static void setMoneyMap(HashMap<Integer, Integer> moneyMap) {
        moneyMap.put(3, 5000);
        moneyMap.put(4, 50000);
        moneyMap.put(6, 2000000000);
        moneyMap.put(7, 30000000);
    }

    private boolean isBonusNumberMatch(Lotto lotto) {
        return lotto.getLottoNumbers().contains(player.getBonusNumber());
    }

    public double getEarnRatio() {
        return (player.getLottoSum() / player.getMoney()) * 100.0;
    }
}
