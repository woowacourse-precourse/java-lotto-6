package lotto.view.impl;

import java.util.Arrays;
import lotto.constants.CommonLetter;
import lotto.constants.GameMessages;
import lotto.constants.Prize;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.OutputView;

import java.util.stream.Collectors;

public class OutputViewImpl implements OutputView {
    private static final String NEW_LINE = CommonLetter.NEW_LINE.getLetter();
    private static final String HORIZONTAL_LINE = CommonLetter.HORIZONTAL_LINE.getLetter();
    private static final String HYPHEN = CommonLetter.HYPHEN.getLetter();
    private static final String ERROR_PREFIX = CommonLetter.ERROR_PREFIX.getLetter();

    @Override
    public void printLottos(Lottos lottos) {
        System.out.println(NEW_LINE + lottos.getLottos().size() + "개를 구매했습니다.");
        lottos.getLottos().forEach(Lotto::print);
    }

    @Override
    public void printGameResult(Lottos lottos) {
        System.out.println(
            GameMessages.OUTPUT_STATISTICS.getMessage() + NEW_LINE + HORIZONTAL_LINE);

        String result = Arrays.stream(Prize.values())
            .filter(prize -> prize != Prize.NONE)
            .map(prize -> prize + HYPHEN + lottos.getPrizeCount(prize) + "개")
            .collect(Collectors.joining(NEW_LINE));

        System.out.println(result);
    }

    @Override
    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
