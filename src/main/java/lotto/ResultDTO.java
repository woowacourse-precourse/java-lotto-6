package lotto;

import java.util.List;

public record ResultDTO(List<Integer> winningNumberResult, List<Boolean> bonusResult) {
    public ResultDTO(List<Integer> winningNumberResult, List<Boolean> bonusResult) {
        this.winningNumberResult = winningNumberResult;
        this.bonusResult = bonusResult;
    }
}
