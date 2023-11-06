package lotto;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구매금액을 입력해 주세요.");
        String buyMoney = readLine();
        System.out.println();
        Game game = new Game(Integer.parseInt(buyMoney));
        ArrayList<Integer> test = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = readLine();
        String[] split = numbers.split(",");
        for (String s:split) {
            test.add(Integer.valueOf(s));
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        System.out.println();
        game.printResult(test,Integer.parseInt(bonusNumber));
    }
}
