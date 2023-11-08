package lotto.service;


import static lotto.constant.Message.OUPTUT_OVERALL_ROI;
import static lotto.constant.Message.OUTPUT_MY_LOTTOS;
import static lotto.constant.Message.OUTPUT_PREPARE_RESULT;
import static lotto.constant.Message.OUTPUT_RESULT_FORMAT;
import static lotto.constant.Message.OUTPUT_RESULT_FORMAT_BONUS;

import java.util.List;
import lotto.domain.Lotto;

public class OutputService {

public void printLottos(List<Lotto> lottos) {
    System.out.printf(OUTPUT_MY_LOTTOS.getMsg(), lottos.size());
    for (Lotto lotto: lottos) {
        System.out.println(lotto);
    }
}

public void printResult(int[] placeCount, double ROI) {
    System.out.println(OUTPUT_PREPARE_RESULT.getMsg());
    System.out.printf(OUTPUT_RESULT_FORMAT.getMsg(), 3, 5000, placeCount[5]);
    System.out.printf(OUTPUT_RESULT_FORMAT.getMsg(), 4, 50000, placeCount[4]);
    System.out.printf(OUTPUT_RESULT_FORMAT.getMsg(), 5, 1500000, placeCount[3]);
    System.out.printf(OUTPUT_RESULT_FORMAT_BONUS.getMsg(), 30000000, placeCount[2]);
    System.out.printf(OUTPUT_RESULT_FORMAT.getMsg(), 6, 2000000000, placeCount[1]);
    System.out.printf(OUPTUT_OVERALL_ROI.getMsg(), ROI);
}

}
