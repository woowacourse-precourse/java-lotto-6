package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ExceptionConstant;
import lotto.constant.NumberConstant;
import lotto.constant.StringConstant;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLotto(String winningLotto, String bonusNumber) {
        this.winningLotto = createWinningLotto(winningLotto);
        validateDuplication(winningLotto,bonusNumber);
        validateNumberSize(bonusNumber);
        this.bonusNumber = convertStrToInt(bonusNumber);
    }

    public static WinningLotto of(String winningLotto, String bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private Lotto createWinningLotto(String winningLotto) {
        List<Integer> winningLottoNumbers = convertStrToList(winningLotto);
        return new Lotto(winningLottoNumbers);
    }

    private List<Integer> convertStrToList(String winningLotto) {
        return Arrays.stream(winningLotto.split(StringConstant.DIVISION_STANDARD.getMessage()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateDuplication(String winningLotto, String bonusNumber) {
        List<Integer> winningLottoNumbers = convertStrToList(winningLotto);
        winningLottoNumbers.add(convertStrToInt(bonusNumber));

        if (new HashSet<>(winningLottoNumbers).size() == NumberConstant.LOTTO_COUNT.getNumber()) {
            throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
        }
    }

    private void validateNumberSize(String number) {
        int bonusNumber = convertStrToInt(number);

        if (bonusNumber < NumberConstant.LOTTO_MIN_NUMBER.getNumber()
                || NumberConstant.LOTTO_MAX_NUMBER.getNumber() < bonusNumber) {
            throw new IllegalArgumentException(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private int convertStrToInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
