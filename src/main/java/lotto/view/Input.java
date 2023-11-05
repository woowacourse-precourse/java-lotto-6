package lotto.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Input {
    public List<Integer> numberGenerator() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Randoms.pickNumberInRange(1, 45));
        return lottoNumbers;
    }

    public String getMoney() {
        return Console.readLine();
    }
}
