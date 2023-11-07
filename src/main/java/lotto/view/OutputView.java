package lotto.view;

import static lotto.utils.Message.TICKEY_NUMBER_MESSAGE;
import static lotto.utils.Message.WINNING_RESULT_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.Result;

public class OutputView {
    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(TICKEY_NUMBER_MESSAGE.getMessage().formatted(lottos.size()));
        lottos.forEach((lotto) -> System.out.println(lotto.toString()));
    }

    public void printWinningResult(Result result) {
        System.out.println(WINNING_RESULT_MESSAGE.getMessage());
        System.out.println(result.toString());
    }
}
