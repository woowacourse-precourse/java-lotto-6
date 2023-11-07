package lotto.domain;

import java.util.List;

public class Lucky {

    private final List<Integer> lucky;
    private final int bonus;

    public Lucky(List<Integer> lucky, int bonus) {
        this.lucky = lucky;
        this.bonus = bonus;
    }

    public Rank checkWinning(Lotto lotto) {
        Comparator comparator = new Comparator();
        boolean bonus=false;
        int count = comparator.compare(lotto.getNumbers(), lucky);
        if(count==5){
            bonus = checkBonus(lotto.getNumbers());
        }
        if(count<3){
            count=0;
        }
        return Rank.valueOfCount(count, bonus);
    }

    public boolean checkBonus(List<Integer> lotto) {
        return lotto.contains(bonus);
    }

}
