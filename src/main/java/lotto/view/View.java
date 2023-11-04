package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String inputValue() {
        return Console.readLine();
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printPurchaseLottoAmount(int purchasedLottoAmount) {
        System.out.println();
        System.out.println(purchasedLottoAmount + "개를 구매했습니다.");
    }

    public void printIssuedLotto(String lotto) {
        System.out.println(lotto);
    }
}
