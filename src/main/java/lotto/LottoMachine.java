package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int RANGE_MIN_VALUE = 1;
    private static final int RANGE_MAX_VALUE = 45;
    private final int LOTTO_PRICE = 1000;
    private final int LOTTO_LENGTH = 6;

    public List<Lotto> inputPurchasePrice(int price) {
        checkRemain(price);

        List<Lotto> lottos = new ArrayList<>();
        int numOfLottos = price / LOTTO_PRICE;
        IntStream.range(0, numOfLottos)
                .forEach(i -> lottos.add(pickLotto()));

        printPurchaseResult(lottos);
        return lottos;
    }

    private void printPurchaseResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    private void checkRemain(int price) {
        if (0 != price % LOTTO_PRICE) {
            throw new IllegalArgumentException(CustomErrorMessage.CHANGE);
        }
    }

    private Lotto pickLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANGE_MIN_VALUE, RANGE_MAX_VALUE, LOTTO_LENGTH);
        ArrayList<Integer> numberArray = new ArrayList<>(numbers);
        Collections.sort(numberArray);

        return new Lotto(numberArray);
    }
}
