package lotto.domain;

import static lotto.util.LottoConstant.*;
import static lotto.view.OutputView.*;

public class LottoResult {

    private int place[] = new int[5];

    public void checkRanking(int match , boolean bonus) {
        if(is1stPlace(match)) {
            place[0]++;
            return;
        }

        if(is2stPlace(match , bonus)) {
            place[1]++;
            return;
        }

        checkRemainPlace(match , bonus);
    }

    private boolean is1stPlace(int match) {
        return match >= 6;
    }

    private boolean is2stPlace(int match , boolean bonus) {
        return match == 5 && bonus;
    }

    private void checkRemainPlace(int match , boolean bonus) {
        if(bonus) {
            match += 1;
        }

        if(match >= 3) { // 3 -> 4 , 4 -> 3 , 5 -> 2 , 6 -> 1
            place[7 - match]++;
        }
    }

    public void printLottoResult(int price) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(PRINT_5ST.getMessage() , place[4])).append("\n");
        sb.append(String.format(PRINT_4ST.getMessage() , place[3])).append("\n");
        sb.append(String.format(PRINT_3ST.getMessage() , place[2])).append("\n");
        sb.append(String.format(PRINT_2ST.getMessage() , place[1])).append("\n");
        sb.append(String.format(PRINT_1ST.getMessage() , place[0])).append("\n");
        sb.append(String.format(PRINT_RATE_OR_RETURN.getMessage() , getRateOfReturn(price))).append("\n");

        System.out.println(sb);
    }

    private double getRateOfReturn(int price) {
        return (getRevenue() / price) * 100;
    }

    private long getRevenue() {
        return place[0] * LOTTO_1ST_PRICE.getValue() +
                place[1] * LOTTO_2ST_PRICE.getValue() +
                place[2] * LOTTO_3ST_PRICE.getValue() +
                place[3] * LOTTO_4ST_PRICE.getValue() +
                place[4] * LOTTO_5ST_PRICE.getValue();
    }

}
