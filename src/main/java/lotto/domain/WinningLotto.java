package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.StringConstant;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLotto(String winningLotto, String bonusNumber) {
        this.winningLotto = createWinningLotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningLotto, String bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private Lotto createWinningLotto(String winningLotto) {
        List<Integer> winningLottoList = convertStrToList(winningLotto);
        return new Lotto(winningLottoList);
    }

    private List<Integer> convertStrToList(String winningLotto) {
        return Arrays.stream(winningLotto.split(StringConstant.DIVISION_STANDARD.getMessage()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
