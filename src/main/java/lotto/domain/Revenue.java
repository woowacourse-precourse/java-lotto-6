package lotto.domain;

import java.util.List;

public class Revenue {
    public static void rateOfRevenue() {
        //수익률 출력(소수점 둘째 자리에서 반올림)
    }
    public static Prize checkPrize(int matchingNumber){
        if(matchingNumber == 3) {
            return Prize.FIFTH_PLACE;
        }
        else if(matchingNumber == 4) {
            return Prize.FOURTH_PLACE;
        }
        else if(matchingNumber == 6) {
            return Prize.FIRST_PLACE;
        }
        return Prize.NO_PLACE;
    }

    public static Prize checkBonusPrize(List<Integer> winningNumber, int bonusNumber){
        for(int num : winningNumber){
            if(num == bonusNumber){
                return Prize.THIRD_PLACE;
            }
        }
        return Prize.SECOND_PLACE;
    }
}
