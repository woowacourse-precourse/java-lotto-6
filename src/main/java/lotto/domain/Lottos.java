package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import lotto.message.LottoResult;

public class Lottos {

    private static final Integer INITIAL_VALUE = 0;
    private static final Integer INCREMENT_COUNT = 1;
    private static final Integer WINNING_THRESHOLD = 3;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public GameResult getResult(WinningNumber winningNumber, int bonusNumber) {
        Map<LottoResult, Integer> result = getInitialResultMap();

        lottos.forEach(lotto -> {
                    Optional<LottoResult> lottoResult = checkLottoResult(lotto, winningNumber, bonusNumber);
                    lottoResult.ifPresent(l -> result.merge(l, INCREMENT_COUNT, Integer::sum));
                }
        );
        return new GameResult(result);
    }

    private Optional<LottoResult> checkLottoResult(Lotto lotto, WinningNumber winningNumber, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        int matchedNumberCount = (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
        boolean isBonusNumberMatched = lottoNumbers.contains(bonusNumber);
        if (matchedNumberCount >= WINNING_THRESHOLD) {
            return Optional.of(LottoResult.getMessageByResult(matchedNumberCount, isBonusNumberMatched));
        }
        return Optional.empty();
    }

    private Map<LottoResult, Integer> getInitialResultMap() {
        Map<LottoResult, Integer> result = new TreeMap<>(Comparator.naturalOrder());

        Arrays.stream(LottoResult.values()).forEach(lottoResult -> result.put(lottoResult, INITIAL_VALUE));
        return result;
    }

    public int getPurchaseQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
