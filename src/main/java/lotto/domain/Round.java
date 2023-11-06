package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.global.util.InputManager.inputPayment;
import static lotto.global.util.OutputManager.printHistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Round {

    private int payment;   // 지불 금액
    private List<Integer> winCnts;    // 당첨 개수
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
        return payment / 1000;
    }

    public void judge(Lotto winNum) {
//        for (Lotto lotto : lottos) {
//            int winCnt = 0;
//            for (Integer num : winNum.getNumbers()) {
//                if (lotto.getNumbers().contains(num))
//                    winCnt++;
//            }
//            winCnts.add(winCnt);
//        }
        winCnts = lottos.stream()
                .map(lotto -> (int) winNum.getNumbers().stream()
                        .filter(num -> lotto.getNumbers().contains(num))
                        .count())
                .toList();
    }

    public List<Integer> getWinCnts() {
        return winCnts;
    }

    public void showResult() {
        System.out.printf(
                "3개 일치 (5,000원) - %d개\n"
                        + "4개 일치 (50,000원) - %d개\n"
                        + "5개 일치 (1,500,000원) - %d개\n"
                        + "5개 일치, 보너스 불 일치 (30,000,000원) - %d개\n"
                        + "6개 일치 (2,000,000,000원) - %d개"
                , winCnts.stream().filter(num -> num == 3).count()
                , winCnts.stream().filter(num -> num == 4).count()
                , winCnts.stream().filter(num -> num == 5).count()
                , winCnts.stream().filter(num -> num == 5).count()
                , winCnts.stream().filter(num -> num == 6).count()
        );
    }
}
