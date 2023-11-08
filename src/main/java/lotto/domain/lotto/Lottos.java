package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.generator.LottoNumbersGenerator;
import lotto.exception.ErrorMessagePrinter;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int count, LottoNumbersGenerator generator) {
        for (int iteration = 0; iteration < count; iteration++) {
            addLotto(generator);
        }
    }

    public static Lottos of(int count, LottoNumbersGenerator generator) {
        try {
            return new Lottos(count, generator);
        } catch (IllegalArgumentException e) {
            ErrorMessagePrinter.printError(e);
        }
        return null;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getEachLotto() {
        return lottos.stream().toList();
    }

    private void addLotto(LottoNumbersGenerator generator) {
        lottos.add(new Lotto(generator.generateLottoNumbers()));
    }
}
