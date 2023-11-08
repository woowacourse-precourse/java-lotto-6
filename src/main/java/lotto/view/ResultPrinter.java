package lotto.view;

import lotto.controller.dto.GameResult;
import lotto.controller.dto.LottoResult;

import java.text.MessageFormat;
import java.util.stream.Collectors;

public class ResultPrinter {

    private static final Output output = new PrintStreamOutputView();

    private static final String LOTTO_DELIMITER = ", ";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";

    public static void print(LottoResult result) {
        result.responses().forEach(ResultPrinter::printLotto);
    }

    private static void printLotto(LottoResult.LottoResponse lottoResponse) {
        String lotto = lottoResponse.numbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX));

        output.println(lotto);
    }

    public static void print(GameResult gameResult) {
        output.println("\n당첨 통계\n---");
        gameResult.results().forEach(ResultPrinter::printLottoResult);
        printProfitRate(gameResult);
    }

    private static void printLottoResult(GameResult.LottoGameResult result) {
        String LottoResultMessage = MessageFormat.format("{0}개 일치 ({1}원) - {2}개",
                result.matchCount(),
                result.winningMoney(),
                result.count());
        if (result.winningMoney() == 30_000_000) {
            LottoResultMessage = MessageFormat.format("{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개",
                    result.matchCount(),
                    result.winningMoney(),
                    result.count());
            output.println(LottoResultMessage);
            return;
        }
        output.println(LottoResultMessage);
    }

    private static void printProfitRate(GameResult gameResult) {
        String profitRateMessage = MessageFormat.format("총 수익률은 {0}%입니다.", gameResult.profitRate());
        output.println(profitRateMessage);
    }

}
