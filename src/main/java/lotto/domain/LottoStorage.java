package lotto.domain;


import java.util.List;
import java.util.Objects;
import lotto.domain.dto.LottoNumberCompareResult;
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
        TextBuilder textBuilder = TextBuilder
                .fromString("당첨 통계").appendLineSeparator()
                .append("---").appendLineSeparator();

        for(LottoRank lottoRank : LottoRank.values()) {
            textBuilder.appendInteger(lottoRank.getMatchingCount()).append("개 일치");

            if(lottoRank.isBonusIncluded()) {
                textBuilder.append(", 보너스 볼 일치");
            }

            textBuilder.append(" (").appendPriceAmount(lottoRank.getPrizeAmount()).append(")");

            int count = (int) lottoRanks.stream().filter(lottoRank::equals).count();
            textBuilder.append(" - ").appendInteger(count).append("개").appendLineSeparator();
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