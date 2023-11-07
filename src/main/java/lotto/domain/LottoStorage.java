package lotto.domain;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.dto.LottoNumberCompareResult;
import lotto.domain.dto.LottoRankResult;

public class LottoStorage {

    private final AutomaticLottoStorage automaticLottoStorage;
    private final WinningLotto winningLotto;


    public LottoStorage(AutomaticLottoStorage automaticLottoStorage, WinningLotto winningLotto) {
        this.automaticLottoStorage = automaticLottoStorage;
        this.winningLotto = winningLotto;
    }

    public List<LottoRankResult> finalAllLottoRanks(List<LottoNumberCompareResult> compareResults) {
        return compareResults.stream()
                .map(LottoRank::findLottoRank)
                .filter(Objects::nonNull)
                .map(LottoRankResult::from)
                .collect(Collectors.toList());
    }

    public List<LottoNumberCompareResult> compareAllAutomaticLottoWithWinningNumbers() {

        return automaticLottoStorage.getAutomaticLottos().stream()
                .map(automaticLotto -> compareWithWinningNumbers(automaticLotto.getNumbers()))
                .collect(Collectors.toList());
    }

    // util 라이브러리로 리팩토링
    public LottoNumberCompareResult compareWithWinningNumbers(List<Integer> automaticLottoNumbers) {

        int matchingCount = (int) automaticLottoNumbers.stream().filter(winningLotto::isWinningNumber).count();
        boolean bonusIncluded = false;

        if (automaticLottoNumbers.stream().anyMatch(number -> number.equals(winningLotto.getBonusNumber()))) {
            matchingCount++;
            bonusIncluded = true;
        }

        return LottoNumberCompareResult.of(matchingCount, bonusIncluded);
    }
}