package lotto.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;

public class LottosDto {

    private final List<LottoDto> lottos;

    private LottosDto(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    public static LottosDto from(Lottos lottos) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            lottoDtos.add(LottoDto.from(lotto));
        }
        return new LottosDto(lottoDtos);
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }
}
