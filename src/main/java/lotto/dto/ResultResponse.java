package lotto.dto;

import java.util.Map;

public record ResultResponse(
        Map<String, Integer> prizeResult
) {
    public Map<String, Integer> getResponse() {
        return prizeResult;
    }
}
