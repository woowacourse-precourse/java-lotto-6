package lotto.factory;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

public class WinningLottoFactory {

    private final LottoFactory lottoFactory;

    public WinningLottoFactory(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public WinningLotto createWinningLotto(List<String> winningLottoString, Integer bonusNumber) {
        List<Integer> winningLottoNumbers = convertToLIntegerList(winningLottoString);
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private List<Integer> convertToLIntegerList(List<String> winningLottoString) {
        return winningLottoString.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}