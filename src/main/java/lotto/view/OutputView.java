package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import lotto.domain.lotto.entity.LottoResults;
import lotto.domain.lotto.entity.Lottos;
import lotto.view.dto.LottoResultDTO;
import lotto.view.io.Printer;

public class OutputView {
    private static final DecimalFormat moneyFormat = new DecimalFormat("###,##0");
    private static final DecimalFormat revenueFormat = new DecimalFormat("###,##0.0");
    private final Printer printer = new Printer();

    public void printPurchasedLotto(Lottos lottos) {
        printer.printMessageUsingFormat("%d개를 구매했습니다.", lottos.getSize());

        //todo toString 대신 다른 걸 사용하도록 리팩토링
        lottos.getLottos().forEach(
                lotto -> printer.printMessage(lotto.toString())
        );
    }

    //todo DTO  추가
    public void printResults(LottoResults results) {
        printer.printMessage("당첨 통계");
        printer.printMessage("---");
        results.getCounts().forEach((result, value) -> {
            LottoResultDTO resultDTO = LottoResultDTO.from(result);
            printer.printMessageUsingFormat(
                    resultDTO.getDescriptionFormat() + " - %d개",
                    resultDTO.getMatchingCount(),
                    moneyFormat.format(resultDTO.getPrize()),
                    value);
        });
    }

    public void printRevenue(BigDecimal revenue) {
        printer.printMessageUsingFormat("총 수익률은 %s%%입니다.", revenueFormat.format(revenue));
    }
}
