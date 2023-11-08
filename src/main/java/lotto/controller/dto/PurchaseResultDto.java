package lotto.controller.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;

public record PurchaseResultDto(
    int amount,
    List<List<Integer>> lottos
) {

    public static PurchaseResultDto from(List<Lotto> lottos) {
        int amount = lottos.size();

        List<List<Integer>> lottoNumbers = lottos.stream()
            .map(Lotto::getNumbers)
            .toList();

        return new PurchaseResultDto(amount, lottoNumbers);
    }
}
