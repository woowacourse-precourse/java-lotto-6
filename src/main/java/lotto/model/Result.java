package lotto.model;

import java.text.DecimalFormat;

public class Result {

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private double sum = 0;


    public void recordResult(int cntOfMatch, int bonus){
        boolean hasBonus = false;
        if(bonus != 0)
            hasBonus = true;

        Rank rank = Rank.of(cntOfMatch, hasBonus);

        if(cntOfMatch == 6){
            first++;
            sum += Rank.FIRST.getPrize();
        }
        if(cntOfMatch == 5 && bonus == 1){
            second++;
            sum += Rank.SECOND.getPrize();
        }
        if(cntOfMatch == 5){
            third++;
            sum += Rank.THIRD.getPrize();
        }
        if(cntOfMatch == 4){
            fourth++;
            sum += Rank.FOURTH.getPrize();
        }
        if(cntOfMatch == 3){
            fifth++;
            sum += Rank.FIFTH.getPrize();
        }
    }

    public void printResult(){
        System.out.println(Rank.FIRST.getMessage()+ first + "개");
        System.out.println(Rank.SECOND.getMessage() + second + "개");
        System.out.println(Rank.THIRD.getMessage() + third + "개");
        System.out.println(Rank.FOURTH.getMessage() + fourth + "개");
        System.out.println(Rank.FIFTH.getMessage() + fifth + "개");
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
