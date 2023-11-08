package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class LottoTicketGenerator {
    static List<List<Integer>> lottoNumbersDrawnContainer = new ArrayList<>();

    static void generateRandomLottoNumbers(int lottoPurchaseCount) {
        for (int i = 0; i < lottoPurchaseCount; i++) {
            List<Integer> lottoNumbersDrawnTemp =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> lottoNumbersDrawn = new ArrayList<>(lottoNumbersDrawnTemp);
            Collections.sort(lottoNumbersDrawn);
            lottoNumbersDrawnContainer.add(lottoNumbersDrawn);
            OutputView.printLottoNumbers(lottoNumbersDrawn);
        }
    }
}



