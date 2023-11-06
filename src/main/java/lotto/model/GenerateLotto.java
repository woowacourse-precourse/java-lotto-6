package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Random;

public class GenerateLotto {
    static final int START_INCLUSIVE=1;
    static final int END_INCLUSIVE=45;
    static final int LOTTO_NUMBER_SIZE=6;

    public Lotto generateLotto(){
        return new Lotto(generate());
    }
    private List<Integer> generate(){
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE,END_INCLUSIVE,LOTTO_NUMBER_SIZE);
    }
}
