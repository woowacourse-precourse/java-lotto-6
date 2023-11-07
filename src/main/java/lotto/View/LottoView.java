package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
public class LottoView {
    private int price;

    public void printInputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void setPrice() {
        this.price = Integer.parseInt(Console.readLine());
    }

    public int getPrice() {
        return price;
    }

    public void printNumOfLotto(int number) {
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottos(List<Integer> lotto[], int buyCount){
        for(int i =0; i<buyCount; i++)
            System.out.println(lotto[i]);
    }
}
