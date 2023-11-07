package lotto.domain;


import java.util.List;
import java.util.Objects;
import lotto.common.PrintMessage;
import lotto.domain.dto.LottoNumberCompareResult;
import lotto.util.KRWFormatter;
import lotto.util.LottoGamePrinter;
import lotto.util.LottoProfitCalculator;
import lotto.util.TextBuilder;

public class LottoStorage {

    private final AutomaticLottoStorage automaticLottoStorage;
    private final WinningLotto winningLotto;


    private LottoStorage(AutomaticLottoStorage automaticLottoStorage, WinningLotto winningLotto) {
        this.automaticLottoStorage = automaticLottoStorage;
        this.winningLotto = winningLotto;
    }

    public static LottoStorage of(AutomaticLottoStorage automaticLottoStorage, WinningLotto winningLotto) {
        return new LottoStorage(automaticLottoStorage, winningLotto);
    }

    public void showAllLottoRankResult(List<LottoRank> lottoRanks) {
        TextBuilder textBuilder = TextBuilder.fromString(PrintMessage.WINNING_STATISTICS_HEADER.getMessage()).appendLineSeparator();
        textBuilder.append(PrintMessage.WINNING_STATISTICS_SEPARATOR.getMessage()).appendLineSeparator();

        for(LottoRank lottoRank : LottoRank.values()) {
            textBuilder
                    .append(String.format(PrintMessage.MATCH_COUNT_FORMAT.getMessage(), lottoRank.getMatchingCount()));

            if(lottoRank.isBonusIncluded()) textBuilder.append((PrintMessage.BONUS_BALL_FORMAT.getMessage()));
            textBuilder.append(String.format(PrintMessage.PRIZE_AMOUNT_FORMAT.getMessage(), KRWFormatter.format(lottoRank.getPrizeAmount())));

            int count = (int) lottoRanks.stream().filter(lottoRank::equals).count();
            textBuilder.append(String.format(PrintMessage.MATCHING_COUNT_FORMAT.getMessage(), count))
                    .appendLineSeparator();
        }

        LottoGamePrinter.println(textBuilder.build());
    }

    public void showLottoProfitRate(List<LottoRank> lottoRanks) {
        Double profit = LottoProfitCalculator.calculate(lottoRanks, automaticLottoStorage.getTotalPrice());

        TextBuilder textBuilder = TextBuilder.fromString("총 수익률은 ").appendDouble(profit).append("%입니다.").appendLineSeparator();
        LottoGamePrinter.println(textBuilder.build());
    }

    public List<LottoRank> compareAllAutomaticLottoWithWinningNumbers() {

        return automaticLottoStorage.getAutomaticLottos().stream()
                .map(automaticLotto -> compareWithWinningNumbers(automaticLotto.getNumbers()))
                .map(LottoRank::findLottoRank)
                .filter(Objects::nonNull).toList();
    }

    private LottoNumberCompareResult compareWithWinningNumbers(List<Integer> automaticLottoNumbers) {

        int matchingCount = (int) automaticLottoNumbers.stream().filter(winningLotto::isWinningNumber).count();
        boolean bonusIncluded = false;

        if (automaticLottoNumbers.stream().anyMatch(number -> number.equals(winningLotto.getBonusNumber()))) {
            matchingCount++;
            bonusIncluded = true;
        }

        return LottoNumberCompareResult.of(matchingCount, bonusIncluded);
    }
}