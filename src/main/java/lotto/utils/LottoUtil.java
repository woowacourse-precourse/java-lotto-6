package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    final String NUM_REG = "[0-9]+";

    public String getUserInput() {
        return Console.readLine();
    }

    public List<List<Integer>> getLottos(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(numbers);
        }
        return lottos;
    }

    public boolean validateNumberCheck(String number) {
        String deleteCommaNumber = number.replaceAll(",", "").replaceAll(" ", "");
        if(deleteCommaNumber.matches(NUM_REG)) {
            return true;
        }
        System.out.println(ExceptionMessage.WINNING_NUMBER.getValue());
        return false;
    }
}
