package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottoBundle;
import lotto.dto.LottoResult;
import lotto.util.StringFormatter;

import java.util.List;

public class OutputView {

    private static final String BUY_LOTTO_MESSAGE = "%s개를 구매했습니다.%n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";

    private final StringFormatter formatter;

    public OutputView(StringFormatter formatter) {
        this.formatter = formatter;
    }

    public void printLottoBundle(LottoBundle lottoBundle) {
        System.out.printf(BUY_LOTTO_MESSAGE, lottoBundle.amount());
        List<Lotto> bundle = lottoBundle.bundle();
        for (Lotto lotto : bundle) {
            String lottoLine = formatter.makeLottoLine(lotto);
            System.out.println(lottoLine);
        }
    }

    public void printLottoResult(LottoResult result) {
        String resultLine = formatter.makeResultLines(result);
        System.out.println(RESULT_MESSAGE);
        System.out.println(resultLine);
    }
}
