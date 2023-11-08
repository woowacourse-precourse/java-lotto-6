package lotto.engine.dto;

import java.util.Map;

public record WinningResult(double profit, Map<Integer, Integer> winningCriteria, int specailMatchCount) {

}
