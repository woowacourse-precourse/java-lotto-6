package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<Integer,Integer>matchCountToCount;
    private final Map<Integer,Integer>prizeMap;
    private int secondPrizeCount = 0;

    public WinningResult() {
        this.matchCountToCount = new HashMap<>(); //로또 승리 수당 map
        this.prizeMap =Map.of(
                6,2_000_000_000,
                5, 1_500_000,
                4, 50_000,
                3, 5_000
        );
        this.secondPrizeCount =  0; //2등의 경우 보너스 참거짓을 확인해야하므로 따로 만듦
    }

    public void addResult(int matchCount,boolean bonusMatch){ //2등확인 함수
        if(matchCount==5&&bonusMatch){
            secondPrizeCount ++;
        }
        if(prizeMap.containsKey(matchCount)){ //그 외의 정답매칭 함수
            matchCountToCount.put(matchCount,matchCountToCount.getOrDefault(matchCount,0)+1);
        }
    }

    public void printResult(int purchasedAmount){ //출력함수
        double totalPrize = 0;
        System.out.println("당첨 통계 : ");
        System.out.println("--------");

        for(int matchCount =6;matchCount>=3;matchCount--){
            int count = matchCountToCount.getOrDefault(matchCount,0);
            int prize = prizeMap.getOrDefault(matchCount,0);
            if(matchCount==5) { //2등 출력
                int secondPrize = 30_000_000;
                totalPrize +=(double)secondPrize * secondPrizeCount;
                System.out.printf("5개 번호 + 보너스 번호 일치 (2등, %d원)- %d개\n", secondPrize, secondPrizeCount);
            }
            totalPrize+=(double)prize*count;
            System.out.printf("%d개 일치 (%d원)- %d개\n", matchCount, prize, count);
        }

        double profitRate = (totalPrize / purchasedAmount)/10; // 수익률을 퍼센트로 표시 + 수익률을 계산하였으나 제대로 출력되지 않은듯함
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
