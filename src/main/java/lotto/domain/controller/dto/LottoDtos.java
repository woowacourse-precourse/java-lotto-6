package lotto.domain.controller.dto;

import java.util.List;
import lotto.domain.entity.User;

public record LottoDtos(
        List<LottoDto> lottoDtos
) {

    public static LottoDtos of(final User user) {
        return new LottoDtos(
                user.getLottos()
                        .stream()
                        .map(lotto -> new LottoDto(lotto.getNumbers()))
                        .toList()
        );
    }

    public int size() {
        return lottoDtos.size();
    }
}
