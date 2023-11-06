package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Ranking;
import lotto.domain.Result;
import lotto.dto.LottoResponseDtos;
import lotto.dto.LottoResponseDtos.*;
import lotto.dto.ResultResponseDto;
import lotto.utils.NumberUtils;
import lotto.utils.constant.Constant;
import lotto.utils.message.Message;

public class OutputView {
    public void printLottos(int count, LottoResponseDtos lottoResponseDtos) {
        printLottoCount(count);
        printAllLotto(lottoResponseDtos);
    }

    private void printLottoCount(int count) {
        System.out.printf(Message.OUTPUT_LOTTO_COUNT, count);
    }

    private void printAllLotto(LottoResponseDtos lottoResponseDtos) {
        for (LottoResponseDto responseDto : lottoResponseDtos.getLottoResponseDtos()) {
            printLottoNumbers(responseDto);
        }
        System.out.println();
    }

    public void printLottoNumbers(LottoResponseDto responseDto) {
        String lotto = String.join(Constant.NUMBER_DELIMITER, NumberUtils.convertToString(responseDto.getLottoNumbers()));
        System.out.println("[" + lotto + "]");
    }

    public void printWinningStatistics(ResultResponseDto responseDto) {
        System.out.println(Message.OUTPUT_WINNING_STATISTICS);
        Arrays.stream(Ranking.values())
            .filter(r -> !r.equals(Ranking.DEFAULT))
            .forEach(r -> System.out.println(printWinningContent(r, responseDto.getCountByRanking(r))));
    }

    private String printWinningContent(Ranking ranking, int count) {
        String priceFormat = String.format("%,d", ranking.getPrice());
        if (ranking.equals(Ranking.SECOND)) {
            return String.format(Message.OUTPUT_WINNING_SECOND_RESULT, ranking.getCount(), priceFormat, count);
        }
        return String.format(Message.OUTPUT_WINNING_RESULT, ranking.getCount(), priceFormat, count);
    }

    public void printYield(double yield) {
        System.out.printf(Message.OUTPUT_YIELD, yield);
    }
}
