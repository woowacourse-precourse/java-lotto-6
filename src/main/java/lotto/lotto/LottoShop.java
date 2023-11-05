package lotto.lotto;

import lotto.player.Wallet;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.constants.MessageConstant.*;
import static lotto.constants.NumConstant.*;

public class LottoShop {
    public Lotto randomLotto() {
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(MIN_VALUE.getValue(), MAX_VALUE.getValue(), DIGIT.getValue());

        return new Lotto(lottoNumbers);
    }
}
