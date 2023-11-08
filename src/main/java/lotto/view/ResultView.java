package lotto.view;

import lotto.Lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void print(Map<Integer,Integer> result, double rate){
        System.out.println("당첨 통계");
        System.out.println("---");
        printResult(result);
        System.out.println("총 수익률은 " + String.format("$.2f",rate) + "%입니다.");
    }
    public static void printResult(Map<Integer,Integer> result){
        DecimalFormat decFormat = new DecimalFormat("###,###");
        int i=3;
        for(Integer key : result.keySet()) {
            if(key == 30000000)
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(key) + "개");
            String price = decFormat.format(key);
            System.out.println(i+"개 일치 ("+price + ") - " + result.get(key) + "개");
            i++;
        }
    }
}
