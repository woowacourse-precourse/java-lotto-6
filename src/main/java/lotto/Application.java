package lotto;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        try{
            LottoGame game = new LottoGame(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
