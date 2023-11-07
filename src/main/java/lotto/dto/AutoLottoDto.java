package lotto.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.AutoLottos;

public class AutoLottoDto {
    private final List<List<Integer>> lottos;

    private AutoLottoDto(final List<List<Integer>> lottos) {
        this.lottos = lottos;
    }


    public static AutoLottoDto fromEnity(final AutoLottos autoLottos) {
        List<List<Integer>> lottos = autoLottos.getLottos().stream().map(lotto -> lotto.getLotto()).toList();
        return new AutoLottoDto(lottos);
    }

    public List<List<Integer>> getAutoLottoDto() {
        return Collections.unmodifiableList(lottos);
    }
}
