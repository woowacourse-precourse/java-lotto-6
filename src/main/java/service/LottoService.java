package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.Lottos;
import domain.Player;
import type.PriceType;

import java.util.*;

public class LottoService {
    public static final int FIFTH_PRICE = 5000;
    public static final int FOURTH_PRICE = 50000;
    public static final int THIRD_PRICE = 1500000;
    public static final int FIRST_PRICE = 2000000000;
    public static final int SECOND_PRICE = 30000000;
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

    public void generatePlayer(int money) {
        player = new Player(money);
    }

    public void setPlayerWinningNumbers(List<Integer> winningNumbers) {
        player.setWinningLotto(winningNumbers);
    }

    public void setPlayerBonusMatchNumber(int bonusNumber) {
        player.setBonusNumber(bonusNumber);
    }

    public HashMap getWinningResult() {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        HashMap<Integer, Integer> moneyMap = new HashMap<>();
        setMoneyMap(moneyMap);
        for (Lotto lotto : lottos.getLottoList()) {
            int matchCount = calculateLottoNumber(resultMap, moneyMap, lotto);
            if (matchCount == 5 && isBonusNumberMatch(lotto)) {
                calculateBonusNumber(resultMap, moneyMap, matchCount);
            }
        }
        return resultMap;
    }

    private void calculateBonusNumber(HashMap<Integer, Integer> resultMap, HashMap<Integer, Integer> moneyMap, int matchCount) {
        resultMap.put(matchCount, resultMap.getOrDefault(matchCount, 0) - 1);
        resultMap.put(BONUS_MATCH_NUMBER, resultMap.getOrDefault(matchCount, 0) + 1);
        player.minus(moneyMap.get(matchCount));
        player.earn(moneyMap.get(BONUS_MATCH_NUMBER));
    }

    private int calculateLottoNumber(HashMap<Integer, Integer> resultMap, HashMap<Integer, Integer> moneyMap, Lotto lotto) {
        int matchCount = lotto.match(player.getWinningLotto().getLottoNumbers());
        resultMap.put(matchCount, resultMap.getOrDefault(matchCount, 0) + 1);
        player.earn(moneyMap.getOrDefault(matchCount, 0));
        return matchCount;
    }

    private static void setMoneyMap(HashMap<Integer, Integer> moneyMap) {
        moneyMap.put(PriceType.FIFTH.getCount(), FIFTH_PRICE);
        moneyMap.put(PriceType.FOURTH.getCount(), FOURTH_PRICE);
        moneyMap.put(PriceType.THIRD.getCount(), THIRD_PRICE);
        moneyMap.put(PriceType.FIRST.getCount(), FIRST_PRICE);
        moneyMap.put(PriceType.SECOND.getCount(), SECOND_PRICE);
    }

    private boolean isBonusNumberMatch(Lotto lotto) {
        return lotto.getLottoNumbers().contains(player.getBonusNumber());
    }

    public double getEarnRatio() {
        return (player.getLottoSum() / player.getMoney()) * 100.0;
    }

    public void addLotto(Lotto lotto) {
        lottos.addLotto(lotto);
    }
}
