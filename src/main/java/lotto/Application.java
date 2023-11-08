package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS = 6;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = generateLottos(numberOfLottos);

        printLottos(lottos);
        Lotto winningLotto = getWinningLotto();
        int bonusBall = getBonusBall();

        int[] matchCounts = countMatches(lottos, winningLotto, bonusBall);
        int prizeMoney = calculatePrizeMoney(matchCounts);
        double profitRate = (double) prizeMoney / purchaseAmount;

        printResult(matchCounts, profitRate);
    }
}
