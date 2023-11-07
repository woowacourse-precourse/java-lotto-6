package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.LottoScore;

public class Ui {

    public static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_CONFIRM_MESSAGE = "%s개를 구매했습니다.";
    public static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final long SCORE_RESULT_DEFAULT_VALUE = 0L;
    public static final String EARNING_PERCENT_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String LOTTO_RESULT_START_MESSAGE = "당첨 통계";
    public static final String LOTTO_RESULT_START_DELIMITERS = "---";
    public static final String ERROR_TAG = "[ERROR] ";

    public void printPrice() {
        System.out.println(PRICE_INPUT_MESSAGE);
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println(String.format(BUY_CONFIRM_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = deepCopy(lotto.getNumbers());
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    private <T> List<T> deepCopy(List<T> original) {
        List<T> copy = new ArrayList<>();
        for (T element : original) {
            copy.add(element);
        }
        return copy;
    }

    public void printReadLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
    }

    public void printReadBonusLottoNumber() {
        System.out.println(INPUT_BONUS_LOTTO_NUMBER_MESSAGE);
    }

    public void printLottoResult(List<LottoScore> scores, double earningPercent) {
        printLottoResultStart();
        printLottoResult(scores);
        printLottoEarningPercent(earningPercent);
    }

    private void printLottoResultStart() {
        System.out.println(LOTTO_RESULT_START_MESSAGE);
        System.out.println(LOTTO_RESULT_START_DELIMITERS);
    }

    private void printLottoResult(List<LottoScore> scores) {
        Map<LottoScore, Long> scoreHistory = scores.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Arrays.stream(LottoResult.values())
                .forEach(lottoResult -> System.out.println(
                        lottoResult.getMessage(
                                scoreHistory.getOrDefault(lottoResult.getLottoScore(), SCORE_RESULT_DEFAULT_VALUE))
                ));
    }

    private void printLottoEarningPercent(double earningPercent) {
        System.out.println(String.format(EARNING_PERCENT_MESSAGE, earningPercent));
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(ERROR_TAG + e.getMessage());
    }
}
