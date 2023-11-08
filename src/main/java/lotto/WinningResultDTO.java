package lotto;

import java.util.Map;
import lotto.domain.Rank;

public class WinningResultDTO {

    private final Map<Rank, Integer> result;

    private WinningResultDTO(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static WinningResultDTO from(Map<Rank, Integer> result) {
        return new WinningResultDTO(result);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}