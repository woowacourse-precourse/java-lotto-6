package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.AutoLottos;
import lotto.domain.Lotto;

public class AutoLottoDto {
    private final List<List<Integer>> lottos;

    private AutoLottoDto(final List<List<Integer>> lottos) {
        this.lottos = lottos;
    }


    public static AutoLottoDto fromEnity(final AutoLottos autoLottos) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (Lotto lotto : autoLottos.getLottos()) {
            List<Integer> sortedLotto = lotto.getLotto().stream().sorted().toList();
            lottos.add(sortedLotto);
        }
        return new AutoLottoDto(lottos);
    }

    public List<List<Integer>> getAutoLottoDto() {
        return Collections.unmodifiableList(lottos);
    }
}
