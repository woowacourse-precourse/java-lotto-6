package lotto.controller;

import lotto.domain.Prize;
import lotto.view.Viewer;

import java.util.Map;

public class OutputController {
    Viewer viewer = new Viewer();

    public void printResult(Map<Prize, Integer> result) {
        viewer.printArgs("");
        viewer.printArgs("당첨 통계");
        for (Prize prize : Prize.values()) {
            int count = result.get(prize);
            System.out.println(prize.getPrizeName() + " - " + count + "개");
        }
    }
}
