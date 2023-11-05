package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import lotto.message.LottoResult;

public class LottoGame {

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;
    private final int bonusNumber;

    public LottoGame(List<Lotto> lottos, WinningNumber winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoResult, Integer> getResult() {
        Map<LottoResult, Integer> result = getResultMap();

        lottos.forEach(lotto -> {
                    Optional<LottoResult> lottoResult = checkLottoResult(lotto);
                    lottoResult.ifPresent(l -> result.merge(l, 1, Integer::sum));
                }
        );
        return result;
    }

    private Map<LottoResult, Integer> getResultMap() {
        Map<LottoResult, Integer> result = new TreeMap<>(Comparator.naturalOrder());

        Arrays.stream(LottoResult.values()).forEach(lottoResult -> result.put(lottoResult, 0));
        return result;
    }

    private Optional<LottoResult> checkLottoResult(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        int matchedNumberCount = (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
        boolean isBonusNumberMatched = lottoNumbers.contains(bonusNumber);
        if (matchedNumberCount >= 3) {
            return Optional.of(LottoResult.getMessageByResult(matchedNumberCount, isBonusNumberMatched));
        }
        return Optional.empty();
    }
}
