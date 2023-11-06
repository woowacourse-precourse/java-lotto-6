package lotto.view;

import static lotto.utils.Message.TICKEY_NUMBER_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(TICKEY_NUMBER_MESSAGE.getMessage().formatted(lottos.size()));
        lottos.forEach((lotto) -> System.out.println(lotto.toString()));
    }
}
