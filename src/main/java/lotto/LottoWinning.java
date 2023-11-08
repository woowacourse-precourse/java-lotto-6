package lotto;

import java.util.Map;
public class LottoWinning {
    private int sum = 0;
    private int prizeMoney = 0;
    public void winningLottos(Map<LottoGame.LottoResult, Integer> resultCounts){
        System.out.println("당첨 통계"+"\n---");
        for (LottoGame.LottoResult result : LottoGame.LottoResult.values()) {
            System.out.println(result.getDescription() + " - " + resultCounts.get(result)+"개");
        }
    }

    // 총 당첨금 반환
    public int money(Map<LottoGame.LottoResult, Integer> resultCounts){
        for (LottoGame.LottoResult result : LottoGame.LottoResult.values()) {
            prizeMoney = calculatePrizeMoney(result.getPrize(),resultCounts.get(result));
        }
        return prizeMoney;
    }

    // 총 당첨금 계산
    public int calculatePrizeMoney(int prize, int result){
        sum += prize * result;
        return sum;
    }

    // 수익률 계산
    public double calcualteEarningRate(int amount, int prizeMoney) {
        double earningRate = 100 + (((double)(prizeMoney - amount) / amount) * 100);

        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
        return earningRate;
    }

}