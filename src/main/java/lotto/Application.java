package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final String START = "구입금액을 입력해 주세요.";

        System.out.println( START );
        String buyLotto = Console.readLine();
        User user = new User();
        user.validateBuyLotto( buyLotto );



    }
}
