package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int requestAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요");
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액을 입력해 주세요.");
            return requestAmount();
        }
    }

    public String requestWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
