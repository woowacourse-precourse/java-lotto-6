package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public View() {
    }

    public void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String input(){
        return Console.readLine();
    }
}
