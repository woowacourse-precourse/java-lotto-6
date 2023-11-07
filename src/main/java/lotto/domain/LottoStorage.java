package lotto.domain;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.dto.LottoNumberCompareResult;

public class LottoStorage {

    private final AutomaticLottoStorage automaticLottoStorage;
    private final WinningLotto winningLotto;


    public LottoStorage(AutomaticLottoStorage automaticLottoStorage, WinningLotto winningLotto) {
        this.automaticLottoStorage = automaticLottoStorage;
        this.winningLotto = winningLotto;
    }

    public List<LottoRank> finalAllLottoRanks(List<LottoNumberCompareResult> compareResults) {
        return compareResults.stream()
                .map(LottoRank::findLottoRank)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<LottoNumberCompareResult> compareAllAutomaticLottoWithWinningNumbers() {

        return automaticLottoStorage.getAutomaticLottos()
                .stream()
                .map(automaticLotto -> compareWithWinningNumbers(automaticLotto.getNumbers()))
                .collect(Collectors.toList());
    }

    public LottoNumberCompareResult compareWithWinningNumbers(List<Integer> automaticLottoNumbers) {

        int matchingCount = (int) automaticLottoNumbers.stream().filter(winningLotto::isWinningNumber).count();
        boolean bonusIncluded = false;

        if (automaticLottoNumbers.stream().anyMatch(number -> number.equals(winningLotto.getBonusNumber()))) {
            matchingCount++;
            bonusIncluded = true;
        }

        return LottoNumberCompareResult.of(matchingCount, bonusIncluded);
    }

    public void showLottoRankResult(List<LottoRank> lottoRanks) {

    }

    public void showprofit() {

    }
}