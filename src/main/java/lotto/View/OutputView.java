package lotto.View;

import java.util.List;
import lotto.Domain.Lotto;

public class OutputView {
    private final String BUY_LOTTO_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private final String HIT_NUMBER_FORMAT = "%d개 일치";
    private final String REWARD_FORMAT = "(%,d원)";
    private final String WINNING_NUM_FORMAT = "%d개";
    private final String REVENUE_MESSAGE_FORMAT = "총 수익률은 %.1f%입니다.";

    private final String WIN_RESULT_MESSAGE = "당첨 통계";
    private final String LINE_DIVIDE_SYMBOL = "---";
    private final String BONUS_SAME_MESSAGE = "보너스 볼 일치";
    private final String COMMAS = ",";
    private final String SPACE = " ";
    private final String DASH = "-";

    private static OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public OutputView getInstance() {
        return INSTANCE;
    }

    public void showBuyLotto(List<Lotto> buyLotto) {
        System.out.println(String.format(BUY_LOTTO_MESSAGE_FORMAT,buyLotto.size()));
        for(Lotto lotto : buyLotto) {
            System.out.println(lotto);
        }
    }

    public void showWinningResult() {
        System.out.println(makeWinningResultMessage());
    }

    public void showRevenue(double revenue) {
        System.out.println(String.format(REWARD_FORMAT,revenue));
    }
    private String makeWinningResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WIN_RESULT_MESSAGE).append("\n").append(LINE_DIVIDE_SYMBOL);
        // 당첨 통계 메세지를 이어 작성
        return stringBuilder.toString();
    }

}
