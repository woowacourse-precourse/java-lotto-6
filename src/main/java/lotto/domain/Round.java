package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.global.util.InputManager.inputPayment;
import static lotto.global.util.OutputManager.printHistory;
import static lotto.global.util.OutputManager.printWinResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Round {

    private int payment;   // 지불 금액
    private List<Integer> winCnts;    // 당첨 개수
    private List<Lotto> lottos = new ArrayList<>();
    private List<Boolean> containsBonus;

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

    public void judge(Lotto winNum, int bonusNum) {

        containsBonus = lottos.stream()
                .map(lotto -> lotto.getNumbers().contains(bonusNum))
                .toList();

        winCnts = lottos.stream()
                .map(lotto -> {
                    int winCnt = 0;

                    for (Integer num : winNum.getNumbers()) {
                        if (lotto.getNumbers().contains(num))
                            winCnt++;
                    }

                    if (lotto.getNumbers().contains(bonusNum))
                        winCnt++;

                    return winCnt;
                })
                .toList();
    }

    public void showResult() {

        long containBonusCnt = (int) (IntStream.range(0, winCnts.size())
                .filter(i -> containsBonus.get(i) && winCnts.get(i) == 5)
                .count());
        long notContainBonusCnt = winCnts.stream().filter(num -> num == 5).count() - containBonusCnt;

        printWinResult(winCnts, containBonusCnt, notContainBonusCnt);
    }

    public List<Integer> getWinCnts() {
        return winCnts;
    }
}
