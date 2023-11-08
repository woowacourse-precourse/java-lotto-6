package output;

import constant.ProfitType;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TotalProfitPrinter {
    public static void printResult(LinkedHashMap<String,Integer> map, int money) {
        DecimalFormat decFormat = new DecimalFormat("###,###");

        int totalProfit = 0;
        for(Entry<String,Integer> entry :map.entrySet()) {
            for(ProfitType profitType:ProfitType.values()) {
                if(profitType.getMatch().equals(entry.getKey())) {
                    System.out.printf("%s (%s원) - %d개\n", profitType.getMatch(),decFormat.format(profitType.getProfit()), entry.getValue());
                    totalProfit += (entry.getValue() * profitType.getProfit());
                }
            }
        }

        double result = (double) totalProfit/money;
        result = (double) Math.round(result * 10000) / 100;

        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }
}
