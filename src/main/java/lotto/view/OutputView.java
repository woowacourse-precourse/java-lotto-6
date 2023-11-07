package lotto.view;

import static lotto.utils.Message.*;

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

    public void printWinningRate(double winningRate) {
        System.out.printf(WINNING_RATE_MASSAGE.getMessage().formatted(winningRate) + "%%입니다.");
    }
}
