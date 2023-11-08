package domain;

import lotto.Lotto;
import lotto.WinInformation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainEvent {

    final static int MATCH_BONUS_OR_NOT_STANDARD = 5;
    final static float DIVIDER_BUY_UNIT = 1000f;

    public Map<WinInformation, Integer> initInformationMap() {
        Map<WinInformation, Integer> tempMap = new LinkedHashMap<>();
        tempMap.put(WinInformation.THREE, 0);
        tempMap.put(WinInformation.FOUR, 0);
        tempMap.put(WinInformation.FIVE_NO_BONUS, 0);
        tempMap.put(WinInformation.FIVE_YES_BONUS, 0);
        tempMap.put(WinInformation.SIX, 0);

        return tempMap;
    }

    public int matchingCount(Lotto lotto, List<Integer> winNumbers) {
        int matchCounter = 0;
        for (int number : lotto.getNumbers()) {
            if (winNumbers.contains(number)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }

    public boolean isContainsBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public WinInformation findRankByCount(int matchCount) {
        for (WinInformation winInformation : WinInformation.values()) {
            if (winInformation.getMatchCount() == matchCount) {
                return winInformation;
            }
        }
        throw new IllegalArgumentException("[ERROR] : 값을 찾을 수 없습니다.");
    }

    public Map<WinInformation, Integer> makeResult(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber) {
        Map<WinInformation, Integer> informationMap = initInformationMap();
        for (Lotto lotto : lottoList) {
            WinInformation key = findRankByCount(matchingCount(lotto, winNumbers));
            if (informationMap.containsKey(key)) {
                if (key.getMatchCount() == MATCH_BONUS_OR_NOT_STANDARD) {
                    if (isContainsBonusNumber(lotto, bonusNumber)) {
                        key = WinInformation.FIVE_YES_BONUS;
                    }
                    if (!isContainsBonusNumber(lotto, bonusNumber)) {
                        key = WinInformation.FIVE_NO_BONUS;
                    }
                }
                informationMap.put(key, informationMap.get(key) + 1);
            }
        }
        return informationMap;
    }

    public void printProfitRatio(List<Lotto> lottoList, Map<WinInformation, Integer> resultMap) {
        long totalPrize = 0;
        for (WinInformation w : resultMap.keySet()) {
            totalPrize += w.getWinMoney() * resultMap.get(w);
        }
        System.out.println("총 수익률은 " + (totalPrize / (DIVIDER_BUY_UNIT * lottoList.size())) * 100 + "%입니다.");
    }

    public void printResult(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<WinInformation, Integer> resultMap = makeResult(lottoList, winNumbers, bonusNumber);
        for (WinInformation w : resultMap.keySet()) {
            System.out.println(w.getRankResult() + resultMap.get(w) + "개");
        }
        printProfitRatio(lottoList, resultMap);
    }

}
