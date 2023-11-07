package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PrizeStorage {
    private int firstPrizeCount = 0;
    private int secondPrizeCount = 0;
    private int thirdPrizeCount = 0;
    private int fourthPrizeCount = 0;
    private int fifthPrizeCount = 0;

    public PrizeStorage(List<Prize> prizes) {
        for(Prize prize : prizes) {
            addPrize(prize);
        }
    }

    private void addPrize(Prize prize) {
        if(prize == Prize.FIRST) {
            firstPrizeCount++;
        }
        if(prize == Prize.SECOND) {
            secondPrizeCount++;
        }
        if(prize == Prize.THIRD) {
            thirdPrizeCount++;
        }
        if(prize == Prize.FOURTH) {
            fourthPrizeCount++;
        }
        if(prize == Prize.FIFTH) {
            fifthPrizeCount++;
        }
    }

    public List<Integer> getPrizeCount() {
        List<Integer> prizeCount = new ArrayList<>();
        prizeCount.add(fifthPrizeCount);
        prizeCount.add(fourthPrizeCount);
        prizeCount.add(thirdPrizeCount);
        prizeCount.add(secondPrizeCount);
        prizeCount.add(firstPrizeCount);
        return prizeCount;
    }
}
