package lotto.controller;

import lotto.domain.Prize;
import lotto.view.Viewer;

import java.util.Map;

public class OutputController {
    Viewer viewer = new Viewer();
    final static int TICKET = 1000;

    public void printResult(Map<Prize, Integer> result, Integer sumOfReturn, Integer ticketCount) {
        viewer.printArgs("");
        viewer.printArgs("당첨 통계");
        viewer.printArgs("---");
        for (Prize prize : Prize.values()) {
            int count = result.get(prize);
            System.out.println(prize.getPrizeName() + " - " + count + "개");
        }
        viewer.printArgs("총 수익률은 " + calcRateOfReturn(sumOfReturn, ticketCount * TICKET) + "%입니다.");
    }

    public Float calcRateOfReturn(Integer sumOfReturn, Integer money) {
        return sumOfReturn.floatValue() / money.floatValue() * 100;
    }


}
