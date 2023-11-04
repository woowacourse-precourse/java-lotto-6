package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.dto.response.LottoDto;
import lotto.dto.response.LottoGroupDto;
import lotto.model.LottoPrize;
import lotto.model.TotalPrize;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private static final String LOTTO_GROUP_SIZE_FORMAT = "%d개를 구매했습니다.";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printExceptionMessage(String exceptionMessage) {
        String formattedExceptionMessage = String.format(EXCEPTION_FORMAT, exceptionMessage);
        println(formattedExceptionMessage);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printLottoGroup(LottoGroupDto lottoGroupDto) {
        int lottoGroupSize = lottoGroupDto.getSize();
        printSize(lottoGroupSize);
        printLottos(lottoGroupDto.getLottos());
        printEmptyLine();
    }

    private void printSize(int lottoGroupSize) {
        String message = String.format(LOTTO_GROUP_SIZE_FORMAT, lottoGroupSize);
        println(message);
    }

    private void printLottos(List<LottoDto> lottos) {
        lottos.forEach(this::printLotto);
    }

    private void printLotto(LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.getNumbers();
        String formattedLottoNumbers = numbers.toString();
        println(formattedLottoNumbers);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printTotalProfit(double totalProfit) {
        String formattedTotalProfit = String.format("%,.1f", totalProfit);
        String message = String.format("총 수익률은 %s%%입니다.", formattedTotalProfit);
        println(message);
    }

    public void printTotalPrize(TotalPrize totalPrize) {
        System.out.println("당첨 통계\n---");
        Map<LottoPrize, Long> prizeSummary = totalPrize.getPrizeSummary();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }
            printLottoPrize(lottoPrize, prizeSummary);
        }
    }

    private void printLottoPrize(LottoPrize lottoPrize, Map<LottoPrize, Long> prizeSummary) {
        Long count = prizeSummary.getOrDefault(lottoPrize, 0L);
        int matchCount = lottoPrize.getMatchCount();
        int prizeAmount = lottoPrize.getPrizeAmount();
        String formattedPrizeAmount = String.format("%,d원", prizeAmount);
        String message = String.format("%d개 일치 (%s) - %d개", matchCount, formattedPrizeAmount, count);
        if (lottoPrize == LottoPrize.SECOND) {
            message = String.format("%d개 일치, 보너스 볼 일치 (%s) - %d개", matchCount, formattedPrizeAmount, count);
        }
        println(message);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
