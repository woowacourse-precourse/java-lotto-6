package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ExceptionConstant;
import lotto.constant.StringConstant;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLotto(String winningLotto, String bonusNumber) {
        this.winningLotto = createWinningLotto(winningLotto);
        validateDuplication(winningLotto,bonusNumber);
        this.bonusNumber = convertStrToInt(bonusNumber);
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

    private int convertStrToInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    private void validateDuplication(String winningLotto, String bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
        }
    }
}
