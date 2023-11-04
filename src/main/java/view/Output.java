package view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;

public class Output {
    private static final String PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_SEPARATOR = "[%s]";
    private static final String LOTTO_NUMBERS_JOIN_SEPARATOR = ", ";

    public static List<Lotto> getLottoNumbers(int purchaseAmount) {
        int lottoAmount = purchaseAmount / 1000;
        System.out.printf(PURCHASE_AMOUNT_MESSAGE + "%n", lottoAmount);

        List<Lotto> lottoList = generateLottoNumbers(lottoAmount);

        printLottoNumbers(lottoList);

        return lottoList;
    }

    private static List<Lotto> generateLottoNumbers(int lottoAmount) {
        return IntStream.range(0, lottoAmount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    private static void printLottoNumbers(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            String lottoNumbers = formatLottoNumbers(numbers);
            System.out.printf(LOTTO_NUMBERS_SEPARATOR + "%n", lottoNumbers);
        });
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_JOIN_SEPARATOR));
    }
}
