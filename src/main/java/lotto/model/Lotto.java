package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.model.User.lottoBoughtNum;
import static lotto.model.User.userBonusNum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.validator.LottoNumValidator;

public class Lotto {
    public static int rank5th, rank4th, rank3rd, rank2nd, rank1st, prize;
    public static List<List<Integer>> allLottoList = new ArrayList<>();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumValidator validator = new LottoNumValidator();
        validator.validate(numbers);
        this.numbers = numbers;
    }

    public static List<List<Integer>> allLottoList() {
        allLottoList = IntStream.range(0, lottoBoughtNum)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return allLottoList;
    }

    public static void rank(Lotto lotto) {
        for (int i = 0; i < User.lottoBoughtNum(); i++) {
            int lottoCount = 0;
            boolean lottoBonusCount = false;

            for (int j = 0; j < 6; j++) {
                if (allLottoList.get(i).contains(lotto.numbers.get(j))) {
                    lottoCount++;
                }
                if (allLottoList.get(i).contains(userBonusNum)) {
                    lottoBonusCount = true;
                }
            }

            if (lottoCount == 3) {
                rank5th++;
                prize += 5000;
            }
            else if (lottoCount == 4) {
                rank4th++;
                prize += 50000;
            }
            else if (lottoCount == 5 && !lottoBonusCount) {
                rank3rd++;
                prize += 1500000;
            }
            else if (lottoCount == 5 && lottoBonusCount) {
                rank2nd++;
                prize += 30000000;
            }
            else if (lottoCount == 6) {
                rank1st++;
                prize += 2000000000;
            }
        }
    }
}