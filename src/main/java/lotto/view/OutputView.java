package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ResultBuilder;
import lotto.validation.ValidateNumberFormat;
import lotto.validation.ValidateThousandWonFormat;

import java.util.List;

public class OutputView {
    private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 통계\n---";

    public void readBuyLottoMessage(int quantity) {
        System.out.println(quantity + BUY_LOTTO_MESSAGE);
    }
    public void readWinningLottoMessage() {
        System.out.println(WINNING_LOTTO_MESSAGE);
    }

    public void readLottoNumbers(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void readWinningLottoResult(int[] result) {
        ResultBuilder resultBuilder = new ResultBuilder();
        System.out.println(resultBuilder.resultBuild(result));
    }
}
