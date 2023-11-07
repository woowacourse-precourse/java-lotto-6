package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

    }
    public static LottoInit ReceiveInitial() {
        LottoInit lottoInit = null;
        try {
            System.out.println("구입금액을 입력해 주세요");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            int numberOfLotto = purchaseAmount / 1000;

            lottoInit = new LottoInit(purchaseAmount, numberOfLotto);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return ReceiveInitial();
        }

        System.out.println("\n" + lottoInit.numberOfLotto + "개를 구매했습니다.");
        return lottoInit;
    }
}
