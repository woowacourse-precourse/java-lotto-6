package strategy;

import domain.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomStrategy implements LottoStrategy{
    public static final int ATTEMPT = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    @Override
    public Lotto issueLotto(ArrayList<Integer> numbers) {
        return new Lotto(generateRandomNumber());
    }

    @Override
    public Integer issueBonus(ArrayList<Integer> numbers, Integer number) {
        number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

        while (numbers.contains(number)) {
            number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        }
        return number;
    }

    public ArrayList<Integer> generateRandomNumber() {
        List<Integer> generateNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, ATTEMPT);
        return new ArrayList<>(generateNumber);
    }
}
