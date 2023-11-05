package lotto.dto;

import java.util.List;

public record LottoResponses(
        List<LottoResponse> lottoResponses
) {
    public List<List<Integer>> getResponses() {
        return lottoResponses.stream()
                .map(LottoResponse::getResponse)
                .toList();
    }
}
