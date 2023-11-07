package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningNumbersInput, int bonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 6 || winningNumbersInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 6개 입력해주세요.");
        }

        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    // Getter 메서드
}
