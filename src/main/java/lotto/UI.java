package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {
    public static String inputMoneyValue(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return money;
    }

    public static void printLottoNum(List<List<Integer>> lottoNum, int moneyValue) {
        System.out.println();
        System.out.println(moneyValue / 1000 + "개를 구매했습니다.");

        for (int i = 0; i < moneyValue / 1000; i++) {
            System.out.println(lottoNum.get(i));
        }
        System.out.println();
    }
}
