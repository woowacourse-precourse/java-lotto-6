package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoExceptionMessage;
import lotto.util.LottoNumbersGenerator;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int count, LottoNumbersGenerator generator) {
        for (int i = 0; i < count; i++) {
            addLotto(generator);
        }
    }

    public static Lottos of(int count, LottoNumbersGenerator generator) {
        try {
            return new Lottos(count, generator);
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.MUST_BETWEEN_START_AND_END_INCLUSIVE.getMessage());
        }
        return null;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public String getEachLotto() {
        return lottos.stream().map(Lotto::getNumbers).collect(Collectors.joining("\n"));
    }

    private void addLotto(LottoNumbersGenerator generator) {
        lottos.add(new Lotto(generator.getSortedLottoNumbers()));
    }
}
