package lotto.service.dto;

import java.util.List;
import lotto.domain.Lottos;

public class LottosDTO {
    private List<List<Integer>> lottos;

    private final int totalLottoBought;

    public LottosDTO(Lottos lottos) {
        this.lottos = lottos.getLottoBundle().stream()
                .map(x -> x.getNumbers().stream().sorted().toList())
                .toList();
        this.totalLottoBought = lottos.numberOfLotto();
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public int getTotalLottoBought() {
        return totalLottoBought;
    }
}
