package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lucky {

    private final List<Integer> lucky;
    private final int bonus;

    public Lucky(List<Integer> lucky, int bonus) {

        validateBonus(lucky,bonus);
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




    private void validateDuplication(List<Integer> numbers){
        if(numbers.size()!=numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자는 불가능합니다.");
        }
    }

    private void validateBonus(List<Integer> numbers,int bonus){
        if(numbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 당첨 번호를 입력해야 합니다.");
        }
    }


}
