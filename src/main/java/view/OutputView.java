package view;

import static consts.Mark.AMOUNT_REGEX;
import static consts.Mark.AMOUNT_SEPARATOR;

import java.util.List;
import model.dto.LottoResponse;
import model.dto.LottoResult;

public class OutputView {

    public void askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void informLottoCount(final int count) {
        printNewLine();
        System.out.printf("%d개를 구매했습니다.", count);
        printNewLine();
    }

    public void noticeGeneratedLottos(final List<LottoResponse> lottoResponses) {
        lottoResponses.stream()
            .map(LottoResponse::getJoinedNumbers)
            .forEach(numbers -> {
                System.out.printf("[%s]", numbers);
                printNewLine();
            });
    }

    public void askLottoNumbers() {
        printNewLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }


    public void askBonusNumber() {
        printNewLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void informWinningStatistics(final List<LottoResult> results) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n당첨 통계\n---\n");
        results.forEach(result -> {
            sb.append(result.equalCount()).append("개 일치");
            if (result.hasBonusBall()) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(String.format(" (%d원) - %d개\n", result.reward(), result.count())
                .replaceAll(AMOUNT_REGEX.mark(), AMOUNT_SEPARATOR.mark()));
        });
        System.out.print(sb);
    }

    public void informRateOfReturn(final double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

    public void showErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printNewLine() {
        System.out.println();
    }
}
