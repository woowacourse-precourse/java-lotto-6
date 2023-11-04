package lotto.view;

import java.util.List;
import lotto.domain.LottosDTO;

public class OutputView {

    private static final String CURRENT_BOUGHT_LOTTO_MESSAGE = "개를 구매했습니다.";

    private OutputView() {
    }

    public static void displayAllLottos(LottosDTO lottosDTO) {
        List<List<Integer>> lottos = lottosDTO.getLottos();
        System.out.println(lottos.size() + CURRENT_BOUGHT_LOTTO_MESSAGE);
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
