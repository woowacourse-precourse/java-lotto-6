package lotto.view;

import lotto.constant.Config;
import lotto.constant.ConsoleMessage;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchasedLottos(LottosDto lottos) {
        String header = String.format(ConsoleMessage.PURCHASED_LOTTO_HEADER.getMessage(), lottos.getSize());
        System.out.println(header);
        for (LottoDto lotto : lottos.getLottosDto()) {
            printPurchasedSingleLotto(lotto.getNumbers());
        }
    }

    private static void printPurchasedSingleLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Config.NUMBER_OF_LOTTO_NUMBERS.getConfig()) {
            throw new IllegalStateException();
        }

        Object[] lottoNumberStrings = lottoNumbers.stream()
                .map(Object::toString)
                .toArray();

        String result = String.format(ConsoleMessage.PURCHASED_SINGLE_LOTTO.getMessage(), lottoNumberStrings);

        System.out.println(result);
    }

    public static void printStatistics() {
        System.out.println(ConsoleMessage.STATISTICS_HEADER.getMessage());
    }

    public static void lineBreak() {
        System.out.println();
    }
}
