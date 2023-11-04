package lotto.domain;

import util.NumberGenerator.INumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoPack {

    private final List<Lotto> lottoPack;

    public LottoPack(int count, INumberGenerator numberGenerator) {
        lottoPack = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoPack.add(new Lotto(numberGenerator.generateNumbers()));
        }
    }

    @Override
    public String toString() {
        return String.join("\n", lottoPack.toString());
    }

}
