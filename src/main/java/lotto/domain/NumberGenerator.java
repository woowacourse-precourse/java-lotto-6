package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int COUNT = 6;
    Validator validator = new Validator();

    public NumberGenerator(){}

    public List<Integer> createNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, COUNT);
        try {
            validator.validateNumbersDuplicate(numbers);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            createNumbers();
        }
        return numbers;
    }
}
