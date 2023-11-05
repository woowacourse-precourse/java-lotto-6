package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.global.util.InputManager.inputPayment;
import static lotto.global.util.OutputManager.printHistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Round {

    private int payment;   // 지불 금액
    private int winCnt;    // 당첨 개수
    private List<Lotto> lottos = new ArrayList<>();

    public void extractor(int totalCnt) {
        for (int i=0; i<totalCnt; i++) {
            List<Integer> randomNums = pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNums);
            Lotto lotto = new Lotto(randomNums);
            lottos.add(lotto);
        }
        printHistory(totalCnt, lottos);
    }

    public int getTotalCnt() {
        payment = inputPayment();
        return payment % 1000;
    }
}
