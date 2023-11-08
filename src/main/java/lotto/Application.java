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
    private static int getPurchaseAmount() {
        int purchaseAmount;
        do {
            System.out.print("구입 금액을 입력해주세요: ");
            try {
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount < LOTTO_PRICE) {
                    throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상 입력하세요.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return purchaseAmount;

}
