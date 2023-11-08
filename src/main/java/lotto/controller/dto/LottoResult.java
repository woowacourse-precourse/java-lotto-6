package lotto.controller.dto;

import lotto.domain.Lotto;
import lotto.policy.SortPolicy;

import java.util.List;

public record LottoResult(List<LottoResponse> responses) {

    public static LottoResult of(List<Lotto> lottos, SortPolicy sortPolicy) {
        List<LottoResponse> responses = lottos.stream()
                .map(
                        lotto -> new LottoResponse(
                                lotto.getNumbers().stream()
                                        .sorted(sortPolicy.sort())
                                        .toList()
                        )
                )
                .toList();

        return new LottoResult(responses);
    }

    public record LottoResponse(List<Integer> numbers) {

    }

}
