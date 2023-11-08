package lotto.model.user;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.util.generator.NumberGenerator;

public class UserLotto {
    private List<Lotto> lottos;

    public UserLotto(int amount, NumberGenerator numberGenerator) {
        lottos = new ArrayList<>();
        while (lottos.size() < amount) {
            lottos.add(new Lotto(numberGenerator));
        }
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
