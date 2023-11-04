package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    public static void printLotteryNumber(List<Lotto> lottery) {
        String lottoNumberInfo = lottery
                .stream()
                .map(Lotto::getNumbers)
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
        System.out.println(lottoNumberInfo);
    }
}
