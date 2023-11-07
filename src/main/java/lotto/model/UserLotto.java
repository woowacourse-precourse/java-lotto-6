package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.generator.NumberGenerator;

public class UserLotto {
    private List<Lotto> lottos = new ArrayList<>();

    public UserLotto(int amount, NumberGenerator numberGenerator) {
        while (lottos.size() < amount) {
            lottos.add(new Lotto(numberGenerator));
        }
    }
}
