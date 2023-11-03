package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottosWithBonus {

    private final List<LottoWithBonus> lottos;

    private LottosWithBonus(final List<LottoWithBonus> lottos) {
        this.lottos = lottos;
    }

    public static LottosWithBonus createAsManyAsCount(final int count) {
        List<LottoWithBonus> lottos = new ArrayList<>();
        IntStream.range(0, count)
            .forEach(repeatCount -> {
                lottos.add(LottoWithBonus.createDefault());
            });

        return new LottosWithBonus(lottos);
    }

    public List<LottoCompareResult> compareAnswerLotto(final LottoWithBonus answerLotto) {
        return lottos.stream()
            .map(lotto -> lotto.compareAnswer(answerLotto))
            .toList();
    }

    public List<LottoWithBonus> getLottos() {
        return lottos;
    }
}
