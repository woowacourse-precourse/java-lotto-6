package lotto.view;

import lotto.domain.LottoBundle;
import lotto.service.dto.Result;
import lotto.view.constant.Format;
import lotto.view.constant.Notice;
import lotto.view.constant.Regex;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printLottoBundle(final LottoBundle lottoBundle) {
        Format.PURCHASE_LOTTO.print(lottoBundle.size());
        lottoBundle.getLottos()
                .forEach(lotto ->
                        System.out.println(lotto.getNumbers())
                );
    }

    public void printResult(Result result) {
        Notice.RESULT.print();
        Notice.BAR.print();

        Format.RESULT_OF_FIFTH.print(result.countOfFifth());
        Format.RESULT_OF_FORTH.print(result.countOfForth());
        Format.RESULT_OF_THIRD.print(result.countOfThird());
        Format.RESULT_OF_SECOND.print(result.countOfSecond());
        Format.RESULT_OF_FIRST.print(result.countOfFirst());

        Format.EARNING_RATE.print(
                Regex.formatCashPrizeWithRounds(result.earningRate())
        );
    }
}
