package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int unit = 1000;
        int money;

        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());

        if(money % unit != 0) {
            System.out.println("[ERROR] 구입금액은 " + unit + "원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }


    }


}
