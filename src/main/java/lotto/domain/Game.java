package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements Constraints {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Game() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (winningNumbers.stream().anyMatch(value -> value == bonusNumber)
                || bonusNumber < MIN
                || bonusNumber > MAX) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 번호는 1부터 45 사이의 로또 번호와 중복되지 않는 숫자여야 합니다.");
        }
    }

    void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Map<ResultCode, Integer> calculate() {
        Map<ResultCode, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            long matchCount = countMatches(lotto);
            if (matchCount < 3) {
                continue;
            }

            updateMap(result, calculateResultCode(matchCount, containsBonusNumber(lotto)));
        }
        return result;
    }

    private long countMatches(Lotto lotto) {
        return winningNumbers.stream().filter(lotto.getNumbers()::contains).count();
    }

    private ResultCode calculateResultCode(long matchCount, boolean isBonusNumberMatch) {
        return Arrays.stream(ResultCode.values())
                .filter(v -> v.matchCount == matchCount && v.bonusMatch == isBonusNumberMatch)
                .findFirst()
                .orElse(null);
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().stream().anyMatch(value -> value == bonusNumber);
    }

    private void updateMap(Map<ResultCode, Integer> map, ResultCode resultCode) {
        if (map.containsKey(resultCode)) {
            map.put(resultCode, map.get(resultCode) + 1);
        } else {
            map.put(resultCode, 1);
        }
    }

    public double calculateProfitability(Map<ResultCode, Integer> map, Integer purchasePrice) {
        double totalPrice = 0;
        if (!map.isEmpty()) {
            totalPrice = map.entrySet().stream()
                    .mapToInt(entry -> entry.getKey().prize * entry.getValue())
                    .sum();
        }
        return Math.round(totalPrice / purchasePrice * 10000.0) / 100.0;
    }
}
