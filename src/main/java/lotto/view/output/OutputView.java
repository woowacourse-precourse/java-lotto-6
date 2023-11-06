package lotto.view.output;

import lotto.dto.LottoDto;
import lotto.model.LottoResult;
import java.util.List;

public final class OutputView {

    private OutputView() {
    }

    public static void printPurchaseLottos(List<LottoDto> lottoDto) {
        String result = OutputFormatter.makePurchaseLottos(lottoDto);
        System.out.println(result);
    }

    public static void printTotalEarningsRate(double totalEarningsRate) {
        String result = OutputFormatter.makeTotalEarningsRate(totalEarningsRate);
        System.out.println(result);
    }

    public static void printLottoResult(List<LottoResult> results) {
        String result = OutputFormatter.makeLottoResult(results);
        System.out.println(result);
    }
}
