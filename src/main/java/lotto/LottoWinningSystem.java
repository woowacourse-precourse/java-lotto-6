package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lotto.MAX_LOTTONUMBER;
import static lotto.Lotto.MIN_LOTTONUMBER;

public class LottoWinning {
    private Lotto lotto;

    void winningNumber(String numbers) {
        List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        lotto = new Lotto(winningNumbers);
    }

    void bonusNumber(int number) {
        validateBonusNumber(number);
        lotto.bonusNumber = number;
    }

    private void validateBonusNumber(int number) {
        if(MIN_LOTTONUMBER >= number && number <= MAX_LOTTONUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 숫자는 1~45사이입니다");
        }
    }
}
