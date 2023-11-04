package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class PlayerLotto {

    private final List<Lotto> playerNumbers;

    public PlayerLotto(List<Lotto> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> generateSixNumbers() {
        List<Integer> sixNumbers = Randoms.pickUniqueNumbersInRange(LottoNumbers.MIN_LOTTO_NUMBER.getNumber(),
                LottoNumbers.MAX_LOTTO_NUMBER.getNumber(), LottoNumbers.LOTTO_SIZE.getNumber());
        Collections.sort(sixNumbers);
        return sixNumbers;
    }
