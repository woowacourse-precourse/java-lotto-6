package lotto.calculation.view;

import static lotto.calculation.model.CalculationConstant.*;

import java.util.Map;

public class CalculationView {
    public static void printResult(Map<Integer, Integer> result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result.get(FIFTH_PLACE)+"개");
        System.out.println("4개 일치 (50,000원) - "+result.get(FOURTH_PLACE)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result.get(THIRD_PLACE)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result.get(SECOND_PLACE)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result.get(FIRST_PLACE)+"개");
    }

    public static void printRevenue(float revenue){
        System.out.println("총 수익률은 "+String.format("%.1f", revenue)+"%입니다.");
    }
}
