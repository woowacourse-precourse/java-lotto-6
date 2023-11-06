package lotto.domain;


import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.LottoNumberCompareResult;

public class LottoStorage {

    private final AutomaticLottoStorage automaticLottoStorage;
    private final WinningLotto winningLotto;


    public LottoStorage(AutomaticLottoStorage automaticLottoStorage, WinningLotto winningLotto) {
        this.automaticLottoStorage = automaticLottoStorage;
        this.winningLotto = winningLotto;
    }

    public List<LottoNumberCompareResult> compareAllAutomaticLottoWithWinningNumbers() {
        List<LottoNumberCompareResult> results = new ArrayList<>();

        automaticLottoStorage.getAutomaticLottos()
                .forEach(lautomaticLotto -> results.add(compareWithWinningNumbers(lautomaticLotto.getNumbers())));

        return results;
    }

    public LottoNumberCompareResult compareWithWinningNumbers(List<Integer> automaticLottoNumbers) {

        int matchingCount = (int) automaticLottoNumbers.stream().filter(winningLotto::isWinningNumber).count();
        boolean bonusIncluded = false;

        if(automaticLottoNumbers.stream().anyMatch(number -> number.equals(winningLotto.getBonusNumber()))) {
            matchingCount++;
            bonusIncluded = true;
        }

        return LottoNumberCompareResult.of(matchingCount, bonusIncluded);
    }
}
