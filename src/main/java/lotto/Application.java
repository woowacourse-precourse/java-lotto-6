package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static final String START = "구입금액을 입력해 주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE = "개를 구매했습니다.";
    private static final int LOTTO_COUNT = 6;

    private static int purchaseAmount;

    public static void main(String[] args) {
        System.out.println(START);
        purchaseAmount = Integer.parseInt(readLine());
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;

        System.out.println();
        System.out.println(numberOfLotto + PURCHASE);
        List<Lotto> lottos = createLotto(numberOfLotto);
        printLotto(lottos);

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.inputWinningNumber();
        winningNumber.compareToLotto(lottos);

        String sum = earningRateCalculation(winningNumber.getMatchWinningNumber(), winningNumber.getMatchBonusNumber());
        System.out.println("총 수익률은 " + sum + "%입니다.");
    }

    public static List<Lotto> createLotto(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lotto = Lotto.randomNumber();
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static String earningRateCalculation(List<Long> matchWinningNumber, List<Long> matchBonusNumber) {
        double totalAmount = 0;
        for (int i = 0; i < LOTTO_COUNT; i++) {
            totalAmount += Prize.matchPrize(matchWinningNumber.get(i), matchBonusNumber.get(i));
        }
        return String.format("%.1f", totalAmount * 100 / purchaseAmount);
    }
}
