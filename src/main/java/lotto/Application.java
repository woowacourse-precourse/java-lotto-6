package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요");
        int count = purchase();
        System.out.println(count + "개를 구매했습니다.");
    }

    private static int purchase() {
        try {
            return Lotto.purchaseCount(Integer.parseInt(readLine()));
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력된 값이 숫자가 아닙니다.");
            return purchase();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 지불한 금액이 나누어 떨어지지 않습니다.");
            return purchase();
        }
    }
}
