package lotto.service;

import lotto.config.WinningResultConfig;
import lotto.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

import static lotto.Message.ErrorMessage.OBJECT_IS_NULL;

public class LottoService {
    private final List<List<Integer>> userLottoNumbers;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final WinningResult winningResult = new WinningResult();
    private final List<Result> results = new ArrayList<>();

    public LottoService(List<List<Integer>> userLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        if (userLottoNumbers == null || winningNumbers == null) {
            throw new NullPointerException(OBJECT_IS_NULL.getMessage());
        }
        this.userLottoNumbers = userLottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LinkedHashMap<WinningResultConfig, Integer> findWinningResult() {
        for (List<Integer> userNumbers : userLottoNumbers) {
            int equalCount = countEqualNumber(userNumbers);
            String bonus = checkBonus(userNumbers, equalCount);

            Result result = new Result(userNumbers, equalCount, bonus);
            results.add(result);
        }
        winningResult.addResult(results.stream()
                .filter(result -> result.getEqualCount() >= Integer.parseInt(WinningResultConfig.THREE.getResultStatus()))
                .collect(Collectors.toList()));

        return winningResult.getWinningResults().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue().size(), (x, y) -> y, LinkedHashMap::new));
    }

    private int countEqualNumber(List<Integer> userNumbers) {
        return Long.valueOf(userNumbers.stream()
                    .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                    .count()).intValue();
    }

    private String checkBonus(List<Integer> userNumbers, int equalCount) {
        if (Integer.toString(equalCount).equals(WinningResultConfig.FIVE.getResultStatus()) &&
                userNumbers.stream()
                        .filter(num -> num == bonusNumber)
                        .count() == 1){
            return "보너스 볼";
        }
        return "";
    }
}
