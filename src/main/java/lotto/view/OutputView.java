package lotto.view;

import lotto.domain.Constants;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OutputView {
    public void printLottos(ArrayList<Lotto> lottos) {
        String lottoList = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));

        System.out.printf((Constants.PRINT_LOTTO_LIST) + "\n", lottos.size());
        System.out.println(lottoList);
    }
}
