package lotto.Model;

import static lotto.Model.Prize.FIFTH;
import static lotto.Model.Prize.FIRST;
import static lotto.Model.Prize.FOURTH;
import static lotto.Model.Prize.SECOND;
import static lotto.Model.Prize.THIRD;

public class WinningDetails {
    private Integer fifth;
    private Integer fourth;
    private Integer third;
    private Integer second;
    private Integer first;

    public WinningDetails(Integer[] result, Integer bonus){
        fifth = result[0];
        fourth = result[1];
        third = result[2];
        second = bonus;
        first = result[3];
    }

    public Double calculatePrize(){
        return  Double.valueOf(fifth * FIFTH.getPrize())
                + (fourth * FOURTH.getPrize())
                + (third * THIRD.getPrize())
                + (second * SECOND.getPrize())
                + (first * FIRST.getPrize());
    }

    public String getResult(){
        String result = "3개 일치 (5,000원) - " + fifth + "개\n"
                + "4개 일치 (50,000원) - " + fourth + "개\n"
                + "5개 일치 (1,500,000원) - " + third + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개\n"
                + "6개 일치 (2,000,000,000원) - " + first + "개\n";
        return result;
    }


}
