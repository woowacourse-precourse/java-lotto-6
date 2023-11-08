package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public Lotto createLotto(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number: numbers.split(",")) {
            try {
                winningNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 정수가 아닌 입력이 있습니다.");
            }
        }
        return new Lotto(winningNumbers);
    }
}
