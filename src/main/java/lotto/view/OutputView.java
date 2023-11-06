package lotto.view;

import lotto.domain.Constants;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class OutputView {
    public void printLottos(ArrayList<Lotto> lottos) {
        String lottoList = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));

        System.out.printf((Constants.PRINT_LOTTO_LIST) + "\n", lottos.size());
        System.out.println(lottoList);
    }

    public void printWinningStatic(String winningStatic) {
        System.out.println(Constants.PRINT_WINNING_STATIC);
        System.out.println(winningStatic);
    }

    public void printRateOfReturn(Double makeOfReturn) {
        System.out.printf(Constants.PRINT_RATE_OF_RETURN, makeOfReturn);
    }
}
