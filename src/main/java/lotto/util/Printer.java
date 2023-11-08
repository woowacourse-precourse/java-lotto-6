package lotto.util;

import java.util.Map;

public class Printer {

    public void println(String value){
        System.out.println(value);
    }

    public void println(double value){
        System.out.println(value);
    }

    public void winningDetails(Map<String, Integer> gradeMap){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+gradeMap.get("5th")+"개");
        System.out.println("4개 일치 (5,0000원) - "+gradeMap.get("4th")+"개");
        System.out.println("5개 일치 (1,500,000원) - "+gradeMap.get("3rd")+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+gradeMap.get("2nd")+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+gradeMap.get("1st")+"개");
    }
}
