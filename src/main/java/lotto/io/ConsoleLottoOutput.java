package lotto.io;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoReceipt;
import lotto.domain.Rank;

public class ConsoleLottoOutput implements LottoOutput {
    private final String MESSAGE_ASKING_MONEY = "구입금액을 입력해 주세요.";
    private final String MESSAGE_RECEIPT_MESSAGE = "개를 구매했습니다.";
    private final String MESSAGE_ASKING_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String MESSAGE_ASKING_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String MESSAGE_RESULT = "당첨 통계\n---";

    private final String FORMAT_PROFIT_PERCENTAGE = "총 수익률은 %.01f%%입니다.";

    private final String BRACKET_OPEN = "[";
    private final String BRACKET_CLOSE = "]";
    private final String OUTPUT_DELIMITER = ", ";


    @Override
    public void printAskingMoney() {
        System.out.println(MESSAGE_ASKING_MONEY);
    }

    @Override
    public void printLottoReceipt(LottoReceipt receipt) {
        System.out.println(receipt.getLotteryCount() + MESSAGE_RECEIPT_MESSAGE);

        List<List<Integer>> drawnLotteryNumbers = receipt.getDrawnLotteryNumbers();
        drawnLotteryNumbers.stream()
                .map(this::formatSingleLotto)
                .forEach(System.out::println);
    }

    private String formatSingleLotto(List<Integer> numbers) {
        String joinedNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(OUTPUT_DELIMITER));

        return BRACKET_OPEN + joinedNumbers + BRACKET_CLOSE;
    }

    @Override
    public void printAskingWinningNumbers() {
        System.out.println(MESSAGE_ASKING_WINNING_NUMBERS);
    }

    @Override
    public void printAskingBonusNumber() {
        System.out.println(MESSAGE_ASKING_BONUS_NUMBER);
    }

    @Override
    public void printResults(Map<Rank, Integer> result) {
        System.out.println(MESSAGE_RESULT);
        List<Rank> resultRanks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

        resultRanks.stream()
                .map(rank -> rank.getResultFormat() + "- " + result.getOrDefault(rank, 0) + "개")
                .forEach(System.out::println);
    }

    @Override
    public void printProfitAsPercentage(double profitAsPercentage) {
        System.out.printf(FORMAT_PROFIT_PERCENTAGE, profitAsPercentage);
    }
}
