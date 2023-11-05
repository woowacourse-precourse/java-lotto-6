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

    public int size() {
        return lottoPack.size();
    }

    @Override
    public String toString() {
        List<String> lottoStrings = lottoPack.stream()
                .map(Lotto::toString)
                .toList();
        return String.join("\n", lottoStrings);
    }

}
