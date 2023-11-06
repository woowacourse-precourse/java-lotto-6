package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    private String input;

    public UserInterface() {
        input = "";
    }

    // 로또 구입 금액, 당첨 번호 , 보너스 번호 입력
    public String getUserInput() {
        input = Console.readLine();
        return input;
    }

    // 에러 문구, 발행한 로또 수량 및 번호, 당첨 내역, 수익률 출력
    public void showText(String text) {
        System.out.println(text);
    }

    public void newLine() {
        System.out.println();
    }
}
