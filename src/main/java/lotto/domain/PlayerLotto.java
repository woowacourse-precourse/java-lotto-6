package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerLotto {

    private final List<Lotto> playerNumbers;

    public PlayerLotto() {
        this.playerNumbers = new ArrayList<>();
    }

    public List<Integer> generateSixNumbers() {
        List<Integer> sixNumbers = Randoms.pickUniqueNumbersInRange(LottoNumbers.MIN_LOTTO_NUMBER.getNumber(),
                LottoNumbers.MAX_LOTTO_NUMBER.getNumber(), LottoNumbers.LOTTO_SIZE.getNumber());
        Collections.sort(sixNumbers);
        return sixNumbers;
    }

    public List<Lotto> generatePlayerNumbers(int buyingCount) {
        for (int i = 0; i < buyingCount; i++) {
            playerNumbers.add(new Lotto(generateSixNumbers()));
        }

        return Collections.unmodifiableList(playerNumbers);
    }
}
