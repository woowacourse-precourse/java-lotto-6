package lotto.model;

import java.text.DecimalFormat;

public class Result {

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private double sum = 0;

    private static final String first_msg = "6개 일치 (2,000,000,000원) - ";
    private static final String second_msg = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String third_msg = "5개 일치 (1,500,000원) - ";
    private static final String fourth_msg = "4개 일치 (50,000원) - ";
    private static final String fifth_msg = "3개 일치 (5,000원) - ";

    public void recordResult(int cntOfMatch, int bonus){
        if(cntOfMatch == 6){
            first++;
            sum += 2000000000;
        }
        if(cntOfMatch == 5 && bonus == 1){
            second++;
            sum += 30000000;
        }
        if(cntOfMatch == 5){
            third++;
            sum += 1500000;
        }
        if(cntOfMatch == 4){
            fourth++;
            sum += 50000;
        }
        if(cntOfMatch == 3){
            fifth++;
            sum += 5000;
        }
    }

    public void printResult(){
        System.out.println(first_msg + first + "개");
        System.out.println(second_msg + second + "개");
        System.out.println(third_msg + third + "개");
        System.out.println(fourth_msg + fourth + "개");
        System.out.println(fifth_msg + fifth + "개");
    }

    public void printRateOfReturn(int money) {
        double rateOfReturn = (sum / money) * 100;
        // DecimalFormat 객체를 생성하고 형식화 패턴을 설정
        DecimalFormat df = new DecimalFormat("#.##");
        // 소수점 둘째 자리에서 반올림하고 0이면 무시한 문자열을 얻어옴
        String formattedNumber = df.format(rateOfReturn);
        System.out.println("총 수익률은 " + formattedNumber + "%입니다.");
    }
}
