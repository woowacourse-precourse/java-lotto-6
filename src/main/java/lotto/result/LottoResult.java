package lotto.result;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoResultType, Integer> lottoResult;
    private double money;

    public LottoResult(double money) {
        // lottoResult Map의 count 값을 0으로 초기화
        this.money = money;
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

    public void printAllLottoResult() {
        for(LottoResultType lottoResultType: lottoResult.keySet()) {
            lottoResultType.print(getCount(lottoResultType));
        }
    }

    // 수익률 계산
    public double calculateRateOfReturn() {
        double rateOfReturn = 0;

        Long sum = 0L;
        for (LottoResultType lottoResultType: lottoResult.keySet()) {
            sum += lottoResultType.getPrice() * getCount(lottoResultType);
        }

        rateOfReturn = ((double) sum / money) * 100;
        rateOfReturn = Math.round(rateOfReturn * 10.0) / 10.0; // 소수점 자릿수 반 올림

        return rateOfReturn;
    }

    // 수익률 출력
    public void printRateOfReturn() {
        StringBuilder sb;
        // 수익률 출력 형식에 맞는 DecimalFormat
        DecimalFormat decFormat = new DecimalFormat("###,##0.0");
        sb = new StringBuilder();
        sb.append("총 수익률은 ").append(decFormat.format(calculateRateOfReturn())).append("%입니다.");

        System.out.println(sb);
    }
}
