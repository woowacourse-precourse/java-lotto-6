package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoResultStatus;
import lotto.exception.ErrorMessagePrinter;
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

    public LottoResult getLottoResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> {
            LottoResultStatus lottoResultStatus = lotto.getLottoResultStatus(winningNumbers, bonusNumber);
            lottoResult.add(lottoResultStatus);
        });
        return lottoResult;
    }

    private void addLotto(LottoNumbersGenerator generator) {
        lottos.add(new Lotto(generator.generateLottoNumbers()));
    }
}
