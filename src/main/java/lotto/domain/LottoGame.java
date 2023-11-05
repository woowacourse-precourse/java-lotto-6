package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import lotto.message.LottoResult;

public class LottoGame {

    private static final Integer INITIAL_VALUE = 0;
    private static final Integer INCREMENT_COUNT = 1;
    private static final Integer WINNING_THRESHOLD = 3;

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;
    private final int bonusNumber;

    public LottoGame(List<Lotto> lottos, WinningNumber winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoResult, Integer> getResult() {
        Map<LottoResult, Integer> result = getInitialResultMap();

        lottos.forEach(lotto -> {
                    Optional<LottoResult> lottoResult = checkLottoResult(lotto);
                    lottoResult.ifPresent(l -> result.merge(l, INCREMENT_COUNT, Integer::sum));
                }
        );
        return result;
    }

    private Map<LottoResult, Integer> getInitialResultMap() {
        Map<LottoResult, Integer> result = new TreeMap<>(Comparator.naturalOrder());

        Arrays.stream(LottoResult.values()).forEach(lottoResult -> result.put(lottoResult, INITIAL_VALUE));
        return result;
    }

    private Optional<LottoResult> checkLottoResult(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        int matchedNumberCount = (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
        boolean isBonusNumberMatched = lottoNumbers.contains(bonusNumber);
        if (matchedNumberCount >= WINNING_THRESHOLD) {
            return Optional.of(LottoResult.getMessageByResult(matchedNumberCount, isBonusNumberMatched));
        }
        return Optional.empty();
    }
}
