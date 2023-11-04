package lotto.view;

import lotto.model.PlayerLotto;
import lotto.model.PlayerLottos;
import lotto.util.NumberConst;

public class OutputView {

    public static final String ISSUE_COUNT_MSG = "개를 구매했습니다.";

    public void printIssueCount(int money) {
        int issueCount = money / NumberConst.DENOMINATION;
        System.out.println();
        System.out.println(issueCount + ISSUE_COUNT_MSG);

    }

    public void printPlayerLottos(PlayerLottos playerLottos) {
        for (PlayerLotto playerLotto : playerLottos.getPlayerLottos()) {
            System.out.println(playerLotto.toString());
        }
    }
}
