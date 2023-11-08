package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class GameManager {
    User user = new User();
    Output output = new Output();
    List<Lotto> lotto = new ArrayList<>();
    List<Integer> winningNumber;
    int bonusNumber;
    int[] countRankArray = {0, 0, 0, 0, 0};
    Rank rank;
    public void start() {
        int inputPrice = user.inputPrice();
        System.out.println();
        int amountOfLotto = buyLotto(inputPrice);
        output.printAmount(amountOfLotto);
        for (int i = 0; i < amountOfLotto; i++) {
            List<Integer> lottoNumber = getLotto();
            output.printLotto(lottoNumber);
            lotto.add(new Lotto(lottoNumber));
        }
        System.out.println();
        winningNumber = user.winningNumbers();
        System.out.println();
        bonusNumber = user.bonusNumber();
        System.out.println();
        checkEachLotto();
        printResult();
    }

    public int buyLotto(int inputPrice) {
        return inputPrice / 1000;
    }

    public List<Integer> getLotto() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sort(lottoNumber);
        return lottoNumber;
    }

    public void checkEachLotto() {
        for (int i = 0; i < lotto.size(); i++) {
            List<Integer> userLotto = lotto.get(i).getNumbers();
            List<Integer> winningLotto = winningNumber;

            int matchCnt = countMatchingNumber(userLotto, winningLotto);
            Rank rank = getRank(userLotto, matchCnt);

            countEachRank(rank, countRankArray);
        }
    }

    public int countMatchingNumber(List<Integer> userLotto, List<Integer> winningLotto) {
        int matchCnt = 0;

        for (int num : userLotto) {
            if (winningLotto.contains(num))
                matchCnt++;
        }

        return matchCnt;
    }

    public Rank getRank(List<Integer> userLotto, int matchCnt) {
        if (matchCnt == 6)
            return Rank.FIRST;
        if (matchCnt == 5 && userLotto.contains(bonusNumber))
            return Rank.SECOND;
        if (matchCnt == 5 && !userLotto.contains(bonusNumber))
            return Rank.THIRD;
        if (matchCnt == 4)
            return Rank.FOURTH;
        if (matchCnt == 3)
            return Rank.FIFTH;

        return Rank.NONE;
    }

    public void countEachRank(Rank rank, int[] countRankArray) {
        if (rank == Rank.FIFTH)
            countRankArray[0]++;
        if (rank == Rank.FOURTH)
            countRankArray[1]++;
        if (rank == Rank.THIRD)
            countRankArray[2]++;
        if (rank == Rank.SECOND)
            countRankArray[3]++;
        if (rank == Rank.FIRST)
            countRankArray[4]++;
    }

    public void printResult() {
        output.printResult(countRankArray);
    }
}
