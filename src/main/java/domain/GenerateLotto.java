package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GenerateLotto {
    public List<Integer> generatedNumbers;
    public GenerateLotto(){
        this.generatedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
