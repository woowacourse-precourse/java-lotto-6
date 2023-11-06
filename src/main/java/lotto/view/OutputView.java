package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.model.LottoGrade;

public class OutputView {
    private static final String LOTTO_FORMAT = "%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String BASE_GRADE_FORMAT = "%s개 일치 (%s원) - %d개";
    private static final String SECOND_GRADE_FORMAT = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RETURN_ON_INVESTMENT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private final DecimalFormat formatter = new DecimalFormat("###,###");

    private OutputView() {
    }

    public static OutputView getInstance() {
        return OutputViewHolder.INSTANCE;
    }

    public void printLottos(final List<LottoDto> lottos) {
        System.out.println();
        System.out.printf(LOTTO_FORMAT, lottos.size());
        for (final LottoDto lotto : lottos) {
            System.out.println(lotto.numbers());
        }
    }

    public void printResult(final List<LottoResultDto> lottoResults) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (final LottoResultDto lottoResult : lottoResults) {
            final String formattedResult = generateResultFormat(lottoResult);
            System.out.println(formattedResult);
        }
    }

    private String generateResultFormat(final LottoResultDto lottoResult) {
        final String formattedAmount = formatter.format(lottoResult.amount());
        if (lottoResult.grade() == LottoGrade.SECOND) {
            return String.format(SECOND_GRADE_FORMAT, formattedAmount, lottoResult.winningCount());
        }
        return String.format(BASE_GRADE_FORMAT,
                lottoResult.correct(),
                formattedAmount,
                lottoResult.winningCount());
    }

    public void printReturnOnInvestment(final double returnOnInvestment) {
        System.out.printf(RETURN_ON_INVESTMENT_FORMAT, returnOnInvestment);
    }

    private static class OutputViewHolder {
        private static final OutputView INSTANCE = new OutputView();
    }
}
