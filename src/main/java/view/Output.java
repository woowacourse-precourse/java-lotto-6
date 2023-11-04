package view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;

public class Output {
    public static final String PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    public static List<Lotto> getLottoNumbers(int purchaseAmount) {
        int lottoAmount = purchaseAmount / 1000;
        System.out.printf(PURCHASE_AMOUNT_MESSAGE + "%n", lottoAmount);

        List<Lotto> lottoList = generateLottoNumbers(lottoAmount);

        return lottoList;
    }

    private static List<Lotto> generateLottoNumbers(int lottoAmount) {
        return IntStream.range(0, lottoAmount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }
}
