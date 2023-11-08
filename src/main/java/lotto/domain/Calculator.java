package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    public Map<Integer, Integer> calculateWinningHistory(Map<Lotto, Integer> hitNumberLottoMap, int bonusNumber) {
        Map<Integer, Integer> winningHistory = generateRankMap();

        hitNumberLottoMap.forEach((lotto, hitNumber) -> {
            if (winningHistory.containsKey(hitNumber)) {
                Integer replaceNumber = hitNumber;
                winningHistory.replace(replaceNumber, winningHistory.get(replaceNumber) + 1);
            }
            if(hitNumber == 5 && lotto.getNumbers().contains(bonusNumber)) {
                winningHistory.replace(51, winningHistory.get(51) + 1);
                winningHistory.replace(5, winningHistory.get(5) - 1);
            }
        });


        return winningHistory;
    }

    public Map<Integer, Integer> generateRankMap(){
        Map<Integer, Integer> winningHistory = new HashMap<>();
        winningHistory.put(6, 0);
        winningHistory.put(5, 0);
        winningHistory.put(51, 0); // 로또 번호 5개 맞고 보너스 1개 맞춘 경우
        winningHistory.put(4, 0);
        winningHistory.put(3, 0);
        return winningHistory;
    }


    public void printWinningHistory(Map<Integer, Integer> winningHistory) {
        System.out.println("3개 일치 (5,000원) - " + winningHistory.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningHistory.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningHistory.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningHistory.get(51) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningHistory.get(6) + "개");
    }

    public void printProfitRate(Map<Integer, Integer> winningHistory, int insertAmount) {
        int profit = 5000*winningHistory.get(3) + 50000*winningHistory.get(4) + 1500000*winningHistory.get(5) + 30000000*winningHistory.get(51) + 2000000000*winningHistory.get(6);
        double profitRate = (double) Math.round((double) profit / insertAmount * 100) /10000;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
