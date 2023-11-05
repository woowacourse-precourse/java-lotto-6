package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoService {

    /**
     * 로또 번호 생성
     */
    public List<Integer> generateLottoNumbers() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lotto;
    }

    /**
     * 로또 당첨 번호 생성
     */
    public ArrayList<Integer> generateLottoWinningNumbers(String winningNumbers) {
        String[] winningNumber = winningNumbers.split(",");
        return Arrays.stream(winningNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * 당첨 내역 계산하기
     */
    public Rank[] calculateWinningDetails(Lotto[] lottos, ArrayList<Integer> winningNumbers, int bonusNumber) {
        Rank[] ranks = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (int i = 0; i < lottos.length; ++i) {
            lottos[i].setRank(winningNumbers, bonusNumber);
            checkRank(ranks, lottos[i]);
        }
        return ranks;
    }

    /**
     * 몇 번째 rank인지 검사
     */
    public void checkRank(Rank[] ranks, Lotto lotto) {
        for(int i = 0; i < ranks.length; ++i) {
            if(ranks[i].getRank() == lotto.getRank().getRank()) {
                ranks[i].setAmount();
            }
        }
    }

    /**
     * 수익률 계산
     */
    public double calculateProfitRate(Rank[] ranks, int amount) {
        double profitRate = 0.0;
        double sum = 0.0;
        for (Rank rank : ranks) {
            sum += rank.getMoney() * rank.getAmount();
        }
        profitRate =  sum/amount;
        return profitRate * 100;
    }

}
