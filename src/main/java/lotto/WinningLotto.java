package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String INVALID_DISTINCT_ERROR_MESSAGE = "[ERROR] 보너스볼은 당첨 번호와 중복될 수 없습니다.";
    private static final String DELIMITER = ",";

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        validateBonusBallDistinct(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto createWinningLotto(String inputWinningNumber, String inputBonusBall) {
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumber.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(winningNumbers);
        LottoNumber lottoNumber = new LottoNumber(inputBonusBall);

        return new WinningLotto(lotto, lottoNumber);
    }

    private void validateBonusBallDistinct(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException(INVALID_DISTINCT_ERROR_MESSAGE);
        }
    }

    public LottoRank matcheLotto(Lotto lotto) {
        int matchingNumbers = lotto.matchNumbers(winningLotto);
        boolean isContainBonusBall = lotto.contains(bonusBall);

        return LottoRank.calculate(matchingNumbers, isContainBonusBall);
    }
}
