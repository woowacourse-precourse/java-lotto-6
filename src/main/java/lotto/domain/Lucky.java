package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lucky {

    private final List<Integer> lucky;
    private final int bonus;

    public Lucky(String lucky, int bonus) {
        this.lucky = translateLucky(lucky);
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


    private List<Integer> translateLucky(String target){
        return translateToInt(separateNames(target));
    }
    private List<String> separateNames(String names) {
        String[] luckyNumber = names.split(",");
        List<String> lucky = new ArrayList<>(Arrays.asList(luckyNumber));
        return lucky;
    }

    private List<Integer> translateToInt(List<String> target){
        List<Integer> lucky=new ArrayList<>();
        target.stream()
                .forEach(t->lucky.add(Integer.parseInt(t)));
        return lucky;
    }


}
