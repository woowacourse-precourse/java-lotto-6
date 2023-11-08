package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSetNumber {
    private static final int Lotto_Count_Number = 6;
    private static final int Min_Lotto_Number = 1;
    private static final int Max_Lotto_Number = 45;


    public static List<Integer> setRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Min_Lotto_Number, Max_Lotto_Number,
                Lotto_Count_Number);
        List<Integer> LottoAllNumbers = new ArrayList<>(numbers);
        Collections.sort(LottoAllNumbers);

        return LottoAllNumbers;
    }
}
