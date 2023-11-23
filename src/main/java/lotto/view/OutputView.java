package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import lotto.domain.lotto.entity.LottoResultCount;
import lotto.domain.lotto.entity.Lottos;
import lotto.view.dto.LottoResultDTO;
import lotto.view.io.Printer;

public class OutputView {
    public static final String FORMAT_REVENUE = "총 수익률은 %s%%입니다.";
    public static final String FORMAT_PURCHASE = "%d개를 구매했습니다.";
    private static final DecimalFormat DECIMAL_FORMAT_MONEY = new DecimalFormat("###,##0");
    private static final DecimalFormat DECIMAL_FORMAT_REVENUE = new DecimalFormat("###,##0.0");
    private final Printer printer = new Printer();

    public void printPurchasedLotto(Lottos lottos) {
        printer.printMessageUsingFormat(FORMAT_PURCHASE, lottos.getSize());

        //todo toString 대신 다른 걸 사용하도록 리팩토링
        lottos.getLottos().forEach(
                lotto -> printer.printMessage(lotto.toString())
        );
    }

    //todo DTO  추가
    public void printResults(LottoResultCount results) {
        printer.printMessage("당첨 통계");
        printer.printMessage("---");
        results.getCounts().forEach((result, value) -> {
            LottoResultDTO resultDTO = LottoResultDTO.from(result);
            printer.printMessageUsingFormat(
                    resultDTO.getDescriptionFormat() + " - %d개",
                    resultDTO.getMatchingCount(),
                    DECIMAL_FORMAT_MONEY.format(resultDTO.getPrize()),
                    value);
        });
    }

    public void printRevenue(BigDecimal revenue) {
        printer.printMessageUsingFormat(FORMAT_REVENUE, DECIMAL_FORMAT_REVENUE.format(revenue));
    }
}
