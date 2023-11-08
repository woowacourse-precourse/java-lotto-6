package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int TICKET_PRICE = 1000;

    public static List<List<Integer>> makeLottoNums(int amount) {
        List<List<Integer>> userLottoList = new ArrayList<>();

        for (int i = 0; i < amount / TICKET_PRICE; i++) {
            List<Integer> numbers = generateLottoNumbers();
            userLottoList.add(numbers);
            System.out.println(numbers);
        }

        System.out.println();
        return userLottoList;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
        Collections.sort(numbers);
        return numbers;
    }
}
