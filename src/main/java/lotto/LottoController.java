package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {

    public LottoController() {
    }

    void play() {
        int LottoNum = moneyInput();
        List<Lotto> LottoList = buyLotto(LottoNum);
        List<Integer> WinningNum = winningNumInput();
        int BonusNum = bonusNumInput();
        RatingCalculate(LottoList, WinningNum, BonusNum);
    }

    private void RatingCalculate(List<Lotto> lottoList, List<Integer> winningNum, int bonusNum) {
        for (Lotto lotto : lottoList) {
            int matchingCount = countMatchingNumbers(lotto.getNumbers(), winningNum);
            boolean hasBonusBall = lotto.getNumbers().contains(bonusNum);
            Rank rank = calculateRank(matchingCount, hasBonusBall);

            System.out.println("로또 번호: " + lotto.getNumbers());
            System.out.println("일치하는 번호 개수: " + matchingCount);
            System.out.println("보너스 볼 일치 여부: " + hasBonusBall);
            System.out.println("등수: " + rank);
            System.out.println("상금: " + rank.getPrize() + "원");
            System.out.println();
        }
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Rank calculateRank(int matchingCount, boolean hasBonusBall) {
        if (matchingCount == 6) {
            return Rank.FIRST;
        }

        if (matchingCount == 5) {
            if (hasBonusBall) return Rank.SECOND;
            return Rank.THIRD;
        }

        if (matchingCount == 4) {
            return Rank.FOURTH;
        }

        if (matchingCount == 3) {
            return Rank.FIFTH;
        }

        return Rank.NO_RANK;
    }

    private List<Lotto> buyLotto(int lottoNum) {
        List<Lotto> LottoList = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> list = makeRandomNum();
            Lotto lotto = new Lotto(list);
            LottoList.add(lotto);
        }
        for (Lotto lotto : LottoList) {
            System.out.println(lotto.getNumbers());
        }
        return LottoList;
    }

    private List<Integer> makeRandomNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        int Money = Integer.parseInt(readLine());
        int LottoNum = Money / 1000;
        System.out.println(LottoNum + "개를 구매했습니다.");
        return LottoNum;
    }

    private int bonusNumInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }

    private List<Integer> winningNumInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }


    public enum Rank {
        FIRST(6, 2000000000),
        SECOND(5, 30000000),
        THIRD(5, 1500000),
        FOURTH(4, 50000),
        FIFTH(3, 5000),
        NO_RANK(0, 0);

        private final int matchCount;
        private final int prize;

        Rank(int matchCount, int prize) {
            this.matchCount = matchCount;
            this.prize = prize;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrize() {
            return prize;
        }
    }


}
