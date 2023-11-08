package lotto.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryResult;
import lotto.domain.LotteryResults;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.User;
import lotto.service.dto.LotteryResultDto;
import lotto.service.dto.LotteryResultsDto;

public class CalculateResultService {

    private final LotteryResultsCalculator calculator;
    private final UserService userService;

    public CalculateResultService(LotteryResultsCalculator calculator, UserService userService) {
        this.calculator = calculator;
        this.userService = userService;
    }

    public LotteryResultsDto calculate(String username) {
        User user = userService.getUser(username);
        List<LotteryReceipt> receipts = user.getReceipts();

        LotteryResults results = calculator.getTotalResults(receipts);
        long resultAmount = results.getTotalAmount();
        long purchaseAmount = calculatePurchaseAmount(receipts);

        double earningRate = ((double) resultAmount / (double) purchaseAmount) * 100;

        return new LotteryResultsDto(convertResults(results), earningRate);
    }

    private static long calculatePurchaseAmount(List<LotteryReceipt> receipts) {
        return receipts.stream()
                .mapToLong(LotteryReceipt::getPurchasedAmount)
                .sum();
    }

    private static List<LotteryResultDto> convertResults(LotteryResults results){
        return results.toList()
                .stream()
                .map(CalculateResultService::convertToLotteryResultDto)
                .collect(toList());
    }
    private static LotteryResultDto convertToLotteryResultDto(LotteryResult result){
        String rankingName = result.ranking().getName();
        int rankingMatches = result.ranking().getMatches();
        int rankingAmount = result.ranking().getAmount();
        int counts = result.counts();
        return new LotteryResultDto(rankingName, rankingMatches, rankingAmount, counts);
    }

}
