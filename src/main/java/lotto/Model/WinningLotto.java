package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto(String input) {
        validate(input);
        try {
            this.winningLotto = new Lotto(Stream.of(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 예시처럼 입력해주세요. 예시) 1,2,3,4,5,6");
        }

    }

    public void contain(Bonus bonus) {
        int bonusNumber = bonus.getBonusNumber();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되면 안됩니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }

    private void validate(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 끝나는 당첨번호는 입력할 수 없습니다.");
        }
    }
}
