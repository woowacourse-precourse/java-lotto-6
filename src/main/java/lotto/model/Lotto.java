package lotto.model;

import static lotto.model.User.lottoBoughtNum;
import static lotto.model.User.userBonusNum;
import static lotto.model.User.userNumListInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.List;

public class Lotto {
    public static int rank5th, rank4th, rank3rd, rank2nd, rank1st, prize;
    public static List<List<Integer>> allLottoList = new ArrayList<>(); // 빈 리스트로 초기화

    static List<Integer> userNumListInt;

    public Lotto(List<Integer> userNumListInt) {
        validate(userNumListInt);
        this.userNumListInt = userNumListInt;
    }

    private void validate(List<Integer> userNumListInt) {
        if (userNumListInt.size() != 6) {
            throw new IllegalArgumentException();
        }
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

    public static void rank() {
        for (int i = 0; i < lottoBoughtNum; i++) {
            int lottoCount = 0;
            int lottoBonusCount = 0;

            for (int j = 0; j < 6; j++) {
                if (allLottoList.get(i).contains(userNumListInt.get(j))) {
                    lottoCount++;
                }
                if (allLottoList.get(i).contains(userBonusNum)) {
                    lottoBonusCount = 1;
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
            else if (lottoCount == 5) {
                rank3rd++;
                prize += 1500000;
            }
            else if (lottoCount == 5 && lottoBonusCount == 1) {
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