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


    public void printLottos(List<Lotto> lottos) {
//        String lottoList = lottos.stream()
//                .map(lotto -> String.join(",", lotto
//                        .getNumbers()
//                        .stream()
//                        .map(Object::toString)
//                        .toList()))
//                .collect(Collectors.joining("\n"));

        StringJoiner joiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        String lottoList = lottos.stream()
                .map(lotto -> {
                    lotto.getNumbers().forEach(number -> joiner.add(number.toString()));
                    return joiner.toString();
                })
                .collect(Collectors.joining("\n"));

        System.out.printf(BUY_SOME_AMOUNT_OF_LOTTO, lottos.size());
        System.out.println(lottoList);
    }

}
