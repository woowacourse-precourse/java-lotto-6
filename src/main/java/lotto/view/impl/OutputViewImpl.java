package lotto.view.impl;

import java.util.Arrays;
import lotto.constants.CommonLetter;
import lotto.constants.ErrorMessages;
import lotto.constants.GameMessages;
import lotto.constants.Prize;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.OutputView;

public class OutputViewImpl implements OutputView {

    @Override
    public void printLottos(Lottos lottos) {
        System.out.println(
            CommonLetter.NEW_LINE.getLetter() + lottos.getLottos().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            lotto.print();
        }
    }

    @Override
    public void printGameResult(Lottos lottos) {
        System.out.println(
            GameMessages.OUTPUT_STATISTICS.getMessage()
                + CommonLetter.NEW_LINE.getLetter() + CommonLetter.HORIZONTAL_LINE.getLetter());
        Arrays.stream(Prize.values())
            .filter(prize -> prize != Prize.NONE)
            .map(
                prize -> prize.toString() + CommonLetter.HYPHEN.getLetter() + lottos.getPrizeCount(prize) + "개")
            .forEach(System.out::println);
    }

    @Override
    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(CommonLetter.ERROR_PREFIX.getLetter() + message);
    }
}
