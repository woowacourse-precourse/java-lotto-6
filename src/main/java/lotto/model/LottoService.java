package lotto.model;

import lotto.config.LottoMessage;
import lotto.config.Rank;
import lotto.dto.request.PurchaseAmountDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.dto.response.LottoResultsDto;
import lotto.dto.response.LottoTicketsDto;
import lotto.util.NumberGenerator;
import lotto.util.ProfitCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private LottoService() {
    }

    public static LottoService getInstance() {
        return new LottoService();
    }

    // 로또 결과 계산과 관련된 주요 로직을 처리하는 메소드
    public LottoResultsDto calculateResults(LottoTicketsDto lottoTicketsDto, WinningNumbersDto winningNumbersDto) {
        Map<Rank, Long> lottoStream = countWinningRanks(lottoTicketsDto, winningNumbersDto);
        LottoResults lottoResults = LottoResults.from(lottoStream);
        String formattedResults = formatResults(lottoResults);
        float profitRate = calculateProfitRate(lottoTicketsDto, lottoResults);

        return LottoResultsDto.of(formattedResults, profitRate);
    }

    // 로또 등수별로 몇 개의 당첨이 있는지 계산하는 메소드
    private static Map<Rank, Long> countWinningRanks(LottoTicketsDto lottoTicketsDto,
                                                     WinningNumbersDto winningNumbersDto) {
        return lottoTicketsDto.getLottoTickets().getLottoTickets().stream()
                .map(lotto -> determineRank(lotto, winningNumbersDto.getNumbers(), winningNumbersDto.getBonus()))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    // 당첨 등수를 결정하는 메소드
    private static Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = countMatches(lotto, winningNumbers);
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    // 로또 번호와 당첨 번호를 비교하여 일치하는 번호의 개수를 반환하는 메소드
    private static long countMatches(Lotto lotto, List<Integer> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static String formatResults(LottoResults lottoResults) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .map(rank -> formatResultLine(rank, lottoResults.getResults().getOrDefault(rank, 0L)))
                .collect(Collectors.joining());
    }

    private static String formatResultLine(Rank rank, Long count) {
        String rankMessage = getRankMessage(rank);
        String matchResultMessage = getMatchResultMessage(rank, count);

        return rankMessage + matchResultMessage;
    }

    private static String getMatchResultMessage(Rank rank, Long count) {
        String prizeMoney = rank.getPrizeMoneyFormatted();
        return LottoMessage.MATCH_RESULT.getFormattedMessage(prizeMoney, count);
    }

    private static String getRankMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return LottoMessage.MATCH_COUNT_WITH_BONUS.getFormattedMessage(rank.getMatchCount());
        }
        return LottoMessage.MATCH_COUNT.getFormattedMessage(rank.getMatchCount());
    }

    private static float calculateProfitRate(LottoTicketsDto lottoTicketsDto, LottoResults lottoResults) {
        int totalCost = lottoTicketsDto.getLottoCost();
        long totalPrize = lottoResults.calculateTotalPrize();
        return ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize);
    }
}
