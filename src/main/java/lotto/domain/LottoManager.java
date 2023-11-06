package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoManager {

    private List<Integer> winningLottoNumbers;

    public LottoManager() {}

    public LottoManager(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }
}
