package lotto.domain;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class RandomGenerator {
    private static List<Integer> numList;
    public RandomGenerator(){
        generate();
    }

    private void generate(){
        numList = randomMachine();
    }

    private List<Integer> randomMachine(){
        return Randoms.pickUniqueNumbersInRange(1,45, 6);
    }

    public List<Integer> getNumList(){
        return numList;
    }
}
