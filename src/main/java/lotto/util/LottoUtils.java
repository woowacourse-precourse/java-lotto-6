package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class LottoUtils {
    public static List<Integer> convertStringToLottoNumberList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 값이어야 합니다.");
        }
        long uniqueNumbersCount = numbers.stream().distinct().count();
        if (uniqueNumbersCount != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 값이 있습니다.");
        }
        return true;
    }

    public static List<Lotto> generateLottoPaper(int howManyLotto) {
        List<Lotto> lottoPapers = new ArrayList<>();
        for (int i = 0; i < howManyLotto; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoPapers.add(new Lotto(randomNumbers));
        }
        return lottoPapers;
    }
}
