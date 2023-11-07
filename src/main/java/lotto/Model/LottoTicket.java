package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int PRICE_PER_TICKET = 1000;
    private final List<Integer> numbers;

    public LottoTicket() {
        this.numbers = generateRandomNumbers();
    }

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_COUNT)
        );
        Collections.sort(randomNumbers);
        return randomNumbers;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }



}