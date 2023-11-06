package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        Amount amount = new Amount(purchaseAmount);
        System.out.println(amount.getAmount() + "개를 구매했습니다.");

        LottoQuantity lottoQuantity = new LottoQuantity(amount.getAmount());
        for (int i = 0; i < lottoQuantity.getQuantity(); i++) {
            System.out.println(new Lotto(new RandomNumber().getRandomNumber()).getNumbers());
        }
    }
}
