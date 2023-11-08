package domain;

import enums.Constants;
import java.util.ArrayList;

public class PrizeCalculate {

    public int calculate(ArrayList<Integer> rank) {
        int prizeSum = 0;
        for (int i = 0; i < rank.size(); i++) {
            prizeSum = prizeSum + getPrize(rank.get(i));
        }
        return prizeSum;
    }

    public int getPrize(int rank) {
        if (rank == 5) {
            return Constants.FIFTH_PRIZE;
        } else if (rank == 4) {
            return Constants.FOURTH_PRIZE;
        } else if (rank == 3) {
            return Constants.THIRD_PRIZE;
        } else if (rank == 2) {
            return Constants.SECOND_PRIZE;
        } else if (rank == 1) {
            return Constants.FIRST_PRIZE;
        }
        return 0;
    }
}
