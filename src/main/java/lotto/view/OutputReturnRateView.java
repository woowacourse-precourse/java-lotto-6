package lotto.view;

import lotto.domain.CompareResult;

public class OutputReturnRateView {
    public void printReturnRate(CompareResult compareResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ").append(String.format("%.1f", compareResult.getReturnRate())).append("%입니다.");
        System.out.println(stringBuilder);
    }
}
