package lotto.view;

import lotto.constant.Config;
import lotto.constant.ConsoleMessage;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchasedLottoHeader() {
        System.out.println(ConsoleMessage.PURCHASED_LOTTO_HEADER.getMessage());
    }

    public static void printPurchasedSingleLotto(List<Integer> lottoNumbers) {
        assert Config.NUMBER_OF_LOTTO_NUMBERS.getConfig() == lottoNumbers.size();

        Object[] lottoNumberStrings = lottoNumbers.stream()
                .map(Object::toString)
                .toArray();

        System.out.println();
    }

    public static void printStatistics() {
        System.out.println(ConsoleMessage.STATISTICS_HEADER.getMessage());

    }
}
