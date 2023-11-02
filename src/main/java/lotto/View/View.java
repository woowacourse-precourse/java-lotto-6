package lotto.View;

import java.util.Scanner;

public class View {
    private Scanner in = new Scanner(System.in);

    public int buyMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return in.nextInt();
    }
    public int buyLotto(int buyMoney){
        System.out.println(buyMoney / 1000 + "개를 구매했습니다.");
        return buyMoney / 1000;
    }
}
