package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    private int price;

    public void printInputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void printNumOfLotto(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }
}
