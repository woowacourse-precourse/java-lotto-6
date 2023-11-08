package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoGame;
import lotto.view.Viewer;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    private LottoGame LottoGame;
    private static Viewer viewer = new Viewer();
    private Integer money;

    public void startGame() {
        viewer.printArgs("구입금액을 입력해 주세요.");
        String moneyArg = Console.readLine();

        while (true) {
            try {
                money = Integer.parseInt(moneyArg);
                break;
            } catch (NumberFormatException e) {
                viewer.printArgs("[ERROR]구입금액을 입력해 주세요.");
                moneyArg = Console.readLine(); // 다시 입력 요청
            }
        }


        System.out.println();
    }

    public List<Integer> playerInput() {
        viewer.printArgs("");
        viewer.printArgs("당첨 번호를 입력해 주세요.");
        return parseStringToList(Console.readLine());
    }

    public static List<Integer> parseStringToList(String input) {
        List<Integer> integerList = new ArrayList<>();
        String[] parts = input.split(",");

        for (String part : parts) {
            try {
                int number = Integer.parseInt(part);
                integerList.add(number);
            } catch (NumberFormatException e) {
                System.err.println("올바른 정수가 아닙니다: " + part);
            }
        }

        return integerList;
    }

    public static Integer bonusInput() {
        viewer.printArgs("");
        viewer.printArgs("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        validation(bonus);
        return Integer.parseInt(bonus);
    }

    private static void validation(String num) throws NumberFormatException {
        int bonusNumber = Integer.parseInt(num);
        if (bonusNumber >= 46) {
            throw new NumberFormatException("[ERROR] 46 이하의 숫자를 입력하세요.");
        }
    }

    public Integer getMoney() {
        return money;
    }

}
