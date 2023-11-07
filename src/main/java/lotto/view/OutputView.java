package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BUY_SOME_AMOUNT_OF_LOTTO = "%d개를 구매했습니다.";
    private static final String DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String NEW_LINE = "\n";


    public void printLottoPurchases(List<Lotto> lottos) {
//        String lottoList = lottos.stream()
//                .map(lotto -> String.join(",", lotto
//                        .getNumbers()
//                        .stream()
//                        .map(Object::toString)
//                        .toList()))
//                .collect(Collectors.joining("\n"));

        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        String lottoList = lottos.stream()
                .map(lotto -> {
                    lotto.getNumbers().forEach(number -> stringJoiner.add(number.toString()));
                    return stringJoiner.toString();
                })
                .collect(Collectors.joining(NEW_LINE));

        System.out.printf(BUY_SOME_AMOUNT_OF_LOTTO, lottos.size());
        System.out.println(lottoList);
    }

    /**
     * 당첨 통계
     * ---
     * 3개 일치 (5,000원) - 1개
     * 4개 일치 (50,000원) - 0개
     * 5개 일치 (1,500,000원) - 0개
     * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
     * 6개 일치 (2,000,000,000원) - 0개
     * 총 수익률은 62.5%입니다.
     */
}
