package lotto.view;

import java.util.List;
import lotto.model.dto.LottoPaper;

public class OuputView {
    private static final String ERROR_HEAD = "[ERROR]";
    private static final String LEFT_BOUND = "[";
    private static final String RIGHT_BOUND = "]";
    private static final String SEPERATOR = ",";
    private static final String WHITE_SPACE = " ";
    private static final String COUNT_MESSAGE = "개를 구매했습니다.";

    public void printErrorMessage(String errorMessage) {
        String formattedErrorMessage = formatErrorMessage(errorMessage);
        System.out.println(formattedErrorMessage);
    }

    public void printPublishedLottos(List<LottoPaper> lottoPapers) {
        printLottoCount(lottoPapers.size());
        printLottoNumbers(lottoPapers);

    }

    private void printLottoCount(int lottoSize) {
        System.out.println(lottoSize + COUNT_MESSAGE);
    }

    private void printLottoNumbers(List<LottoPaper> lottoPapers) {
        for (LottoPaper lottoPaper : lottoPapers) {
            System.out.println(foramtLottoNumbers(lottoPaper));
        }
    }

    private String foramtLottoNumbers(LottoPaper lottoPaper) {
        return LEFT_BOUND
                + concatNumbers(lottoPaper)
                + RIGHT_BOUND;
    }

    private String concatNumbers(LottoPaper lottoPaper) {
        return lottoPaper.getNumbers()
                .stream()
                .map(String::valueOf)
                .reduce((e1, e2) -> e1 + SEPERATOR + WHITE_SPACE + e2)
                .orElseThrow(() -> new IllegalStateException("로또 용지가 없습니다."));
    }


    private String formatErrorMessage(String errorMessage) {
        return ERROR_HEAD + WHITE_SPACE + errorMessage;
    }
}
