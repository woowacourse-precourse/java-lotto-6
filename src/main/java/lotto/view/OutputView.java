package lotto.view;

import static lotto.exception.ExceptionMessage.PREFIX;
import static lotto.view.PromptMessage.INPUT_BONUS_NUMBER;
import static lotto.view.PromptMessage.INPUT_LOTTO_NUMBER;
import static lotto.view.PromptMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.view.PromptMessage.PURCHASE_NUMBERS_OF_LOTTO;
import static lotto.view.PromptMessage.TOTAL_RETURN;
import static lotto.view.PromptMessage.WINNING_STATISTICS;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;

public class OutputView {

    public void printExceptionMessage(String message) {
        System.out.println(PREFIX.getMessage() + message);
    }

    public void printPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printPurchasedLottos(LottosDto lottosDto) {
        System.out.println();
        printPurchasedNumberOfLotto(lottosDto);
        printPurchasedLottoNumbers(lottosDto);
    }

    private void printPurchasedNumberOfLotto(LottosDto lottosDto) {
        System.out.println(String.format(PURCHASE_NUMBERS_OF_LOTTO.getMessage(), lottosDto.lottos().size()));
    }

    private void printPurchasedLottoNumbers(LottosDto lottosDto) {
        lottosDto.lottos().forEach(lottoDto -> {
            List<Integer> lottoNumbers = lottoDto.lottoNumbers().stream()
                    .map(LottoNumberDto::getNumber)
                    .collect(Collectors.toUnmodifiableList());
            System.out.println(lottoNumbers);
        });
        System.out.println();
    }

    public void printInputWinningNumbers() {
        System.out.println(INPUT_LOTTO_NUMBER.getMessage());
    }

    public void printInputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
    }

    public void printRankStatistics() {
        System.out.println();
        System.out.println(WINNING_STATISTICS.getMessage());
    }

    public void printRankResult(RankResultDto rankResultDto) {
        rankResultDto.rank().keySet()
                .forEach(rankPrizeDto -> System.out.println(
                        String.format(rankPrizeDto.prizeMessage(),
                                rankPrizeDto.matchCount(),
                                rankPrizeDto.prizeAmount(),
                                rankResultDto.rank().get(rankPrizeDto))));
    }

    public void printTotalReturn(double totalReturn) {
        System.out.println(String.format(TOTAL_RETURN.getMessage(), totalReturn));
    }
}
