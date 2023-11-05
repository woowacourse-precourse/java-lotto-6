package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String DELIMITER = ",";

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
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
}
