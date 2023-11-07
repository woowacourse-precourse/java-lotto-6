package lotto.view;


import java.util.List;
import lotto.model.LottoPaper;

public class OutputView {
    private static final String BUY_LOTTO = "구입금액을 입력해 주세요";
    private static final String COUNT_LOTTO = "개를 구매했습니다.";
    private static final String PICK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PICK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
    public void printBuyLotto() {
        System.out.println(BUY_LOTTO);
    }

    public void printLottoPapers(List<LottoPaper> papers) {
        printLottoCount(papers.size());

        for(LottoPaper paper : papers) {
            printLottoPaper(paper);
        }
    }

    private void printLottoCount(int count) {
        System.out.println(count + COUNT_LOTTO);
    }

    private void printLottoPaper(LottoPaper paper) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < paper.numbers().size(); i++) {
            sb.append(paper.numbers().get(i));
            if (i < paper.numbers().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }

    public void printPickWinningNumber() {
        System.out.println(PICK_WINNING_NUMBER);
    }

    public void printPickBonusNumber() {
        System.out.println(PICK_BONUS_NUMBER);
    }
}

