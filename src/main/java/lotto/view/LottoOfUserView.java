package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoOfUserView implements View {
    private final List<Lotto> lottos;

    public LottoOfUserView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public void render() {
        System.out.println(calculateOutput()+"\n");
    }

    private String calculateOutput() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
