package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.LottoRank;
import lotto.util.converter.ListConverter;
import lotto.view.dto.LottoResultResponseDto;
import lotto.view.dto.LottosResponseDto;

public class OutputView {
    private static final String OUTPUT_LOTTO_COUNT_FORMAT_MESSAGE = "%d개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String OUTPUT_RATE_OF_RETURN_FORMAT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLottosIssued(LottosResponseDto responseDto) {
        showLottoCount(responseDto.lottoCount());
        for (List<Integer> numbers : responseDto.lottos()) {
            System.out.println(makeLottoNumberFormat(ListConverter.convertToStringList(numbers)));
        }
    }

    private void showLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf(OUTPUT_LOTTO_COUNT_FORMAT_MESSAGE, lottoCount);
        System.out.println();
    }

    private String makeLottoNumberFormat(List<String> numbers) {
        return "[" + String.join(", ", numbers) + "]";
    }

    public void printLottoResult(LottoResultResponseDto responseDto) {
        System.out.println();
        System.out.println(OUTPUT_LOTTO_RESULT_MESSAGE);

        showMatchResult(responseDto.matchResult());
        showReturnOfRate(responseDto.rateOfReturn());
    }

    private void showMatchResult(Map<LottoRank, Integer> matchResult) {
        matchResult.forEach((key, value) -> System.out.println(key.getDescription() + " - " + value + "개"));
    }

    private void showReturnOfRate(double returnOfRate) {
        System.out.printf(OUTPUT_RATE_OF_RETURN_FORMAT_MESSAGE, returnOfRate);
    }
}