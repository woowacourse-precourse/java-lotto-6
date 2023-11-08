package lotto.calculation.view;

import static lotto.calculation.model.CalculationConstant.*;

import java.util.Map;

public class CalculationView {

    private static final StringBuilder sb = new StringBuilder();
    public static void printResult(Map<Integer, Integer> result){
        sb
            .append("당첨 통계").append("\n")
            .append("---").append("\n")
            .append("3개 일치 (5,000원) - ").append(result.get(FIFTH_PLACE)).append("개").append("\n")
            .append("4개 일치 (50,000원) - ").append(result.get(FOURTH_PLACE)).append("개").append("\n")
            .append("5개 일치 (1,500,000원) - ").append(result.get(THIRD_PLACE)).append("개").append("\n")
            .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(result.get(SECOND_PLACE)).append("개").append("\n")
            .append("6개 일치 (2,000,000,000원) - ").append(result.get(FIRST_PLACE)).append("개")
        ;
        System.out.println(sb);
    }

    public static void printRevenue(float revenue){
        sb
            .append("총 수익률은 ")
            .append(String.format("%.1f", revenue))
            .append("%입니다.")
        ;
        System.out.println(sb);
    }
}
