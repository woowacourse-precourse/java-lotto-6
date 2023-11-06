package lotto.dto;

import java.util.Map;

public record ResultResponse(
        Map<Integer, Integer> prizeResult
) {
    public Map<Integer, Integer> getResponse() {
        return prizeResult;
    }
}
