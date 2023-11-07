package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private final static int LOTTO_SIZE = 6;
    private final static long LOTTO_TICKET_PRICE = 1000L;

    public static List<Lotto> make(long money) {
        InputValidator.validateAmountUnitAndMinimum(money);
        List<Lotto> lottoList = new ArrayList<>();

        long total_lotto_count = money / LOTTO_TICKET_PRICE;

        while (lottoList.size() != total_lotto_count) {
            lottoList.add(makeLotto());
        }

        return lottoList;
    }

    private static Lotto makeLotto() {
        return new Lotto(sortedNumbers(Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_SIZE)));
    }

    private static List<Integer> sortedNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }


}
