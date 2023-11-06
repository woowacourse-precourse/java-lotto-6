package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static final String START = "구입금액을 입력해 주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE = "개를 구매했습니다.";


    public static void main(String[] args) {
        System.out.println(START);
        int purchaseAmount = Integer.parseInt(readLine());
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;

        System.out.println();
        System.out.println(numberOfLotto + PURCHASE);

        Lotto.startLotto(numberOfLotto);

        Prize.startPrizeStatistics(purchaseAmount);
    }


}
