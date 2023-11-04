package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        Set numberSet = new HashSet(numbers);
        if(numbers.size() != numberSet.size()){
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    public static Lotto generateLottoByRandom(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return  new Lotto(numbers);
    }

    public LottoResult matchUp(Lotto answer, int bonusNumber) {
        int countBall = 0 ;
        for(Integer number : numbers){
            if(answer.countBall(number)){
                countBall++;
            }
        }
        if(countBall == 5 && answer.countBall(bonusNumber)) {
                countBall = 7;
        }
        return LottoResult.single(countBall);
    }

    private boolean countBall(Integer number) {
        return this.numbers.contains(number) ;
    }

    @Override
    public String toString() {
        List<Integer> result = new ArrayList<>(numbers);
        result.sort((a,b)->a-b);
        return result.toString()+"\n";
    }
}
