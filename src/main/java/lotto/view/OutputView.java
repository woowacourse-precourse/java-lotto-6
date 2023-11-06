package lotto.view;

import lotto.dto.LottoResult;
import lotto.dto.LottosResult;

public class OutputView {
    private static final String PRINT_LOTTO_MESSAGE = "%d개를 구매했습니다.";

    public void printLottos(LottosResult result) {
        System.out.println(PRINT_LOTTO_MESSAGE.formatted(result.lottosCount()));
        for (LottoResult lottoResult : result.lottoResults()) {
            System.out.println(lottoResult.lottoNumbers());
        }
    }
}
