package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {

    public static List<Lotto> createLottoList(int amount) {
        validateAmount(amount);
        int size = amount / 1000;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }

        return lottoList;
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

    public static List<Integer> parseNumberToListInteger(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
