package lotto.view;

import static lotto.constant.message.LottoMessage.LOTTO_NUMBERS_PREFIX_MESSAGE;
import static lotto.constant.message.LottoMessage.LOTTO_NUMBERS_SUFFIX_MESSAGE;
import static lotto.constant.message.LottoMessage.LOTTO_PURCHASE_FIXMESSAGE;
import static lotto.constant.message.LottoMessage.RATE_OF_RETURN_MESSAGE;
import static lotto.constant.message.LottoMessage.SEPARATION;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String DECIMAL_PATTERN = "###,###";
    DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printLottos(List<Lotto> lottos) {
        printLottoCount(lottos);
        for (int i = 0; i < lottos.size(); i++) {
            printLottoNumbers(lottos.get(i));
        }
    }

    private void printLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_PURCHASE_FIXMESSAGE);
    }

    private void printLottoNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        System.out.print(LOTTO_NUMBERS_PREFIX_MESSAGE);
        for (int number : lottoNumbers) {
            System.out.print(number + SEPARATION);
        }
        System.out.println(LOTTO_NUMBERS_SUFFIX_MESSAGE);
    }

    public void printLottosResult(Map<Rank, Integer> results) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (" + decimalFormat.format(FIFTH.getPrize()) + "원) - " + results.get(FIFTH) + "개");
        System.out.println("4개 일치 (" + decimalFormat.format(FOURTH.getPrize()) + "원) - " + results.get(FOURTH) + "개");
        System.out.println("5개 일치 (" + decimalFormat.format(THIRD.getPrize()) + "원) - " + results.get(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + decimalFormat.format(SECOND.getPrize()) + "원) - "
                + results.get(SECOND) + "개");
        System.out.println("6개 일치 (" + decimalFormat.format(FIRST.getPrize()) + "원) - " + results.get(FIRST) + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
