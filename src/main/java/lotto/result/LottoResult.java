package lotto.result;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoResultType, Integer> lottoResult;

    public LottoResult() {
        // lottoResult Map의 count 값을 0으로 초기화
        lottoResult = new EnumMap<>(LottoResultType.class);

        for(LottoResultType lottoResultType: LottoResultType.values()) {
            lottoResult.put(lottoResultType, 0);
        }
    }

    public void incrementCount(LottoResultType resultType) {
        lottoResult.put(resultType, lottoResult.getOrDefault(resultType, 0) + 1);
    }

    public int getCount(LottoResultType resultType) {
        return lottoResult.getOrDefault(resultType, 0);
    }

    public void print() {
        for(LottoResultType lottoResultType: lottoResult.keySet()) {
            lottoResultType.print(getCount(lottoResultType));
        }
    }

    // 수익률 계산
    public double calculateRateOfReturn(double money) {
        double rateOfReturn = 0;

        Long sum = 0L;
        for (LottoResultType lottoResultType: lottoResult.keySet()) {
            sum += lottoResultType.getPrice() * getCount(lottoResultType);
        }

        rateOfReturn = (sum / money) * 100;

        return rateOfReturn;
    }

    // 당첨 통계 출력
    public void printWinnigStatistics(int money) {
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계").append("\n");
        sb.append("---");
        System.out.println(sb);

        print();

        sb = new StringBuilder();
        sb.append("총 수익률은 ").append(String.format("%.1f", calculateRateOfReturn(money))).append("%입니다.");

        System.out.println(sb);
    }
}
