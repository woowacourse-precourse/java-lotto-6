package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int requestAmout() {
        try {
            System.out.println("구입금액을 입력해 주세요");
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액을 입력해 주세요.");
            return requestAmout();
        }
    }

    public static String requestWinNumbers() {
        System.out.println("당첨금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static int requestBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호를 입력해 주세요.");
            return requestBonusNumber();
        }
    }


}
