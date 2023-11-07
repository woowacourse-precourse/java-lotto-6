package lotto.purchase;

import camp.nextstep.edu.missionutils.Console;
public class purchase {

    public static void main(String[] args) {
    }

    public static int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine();
        int money;
        try {
            money = Integer.parseInt(rawMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        try {
            if (money < 1000) {
                throw new IllegalArgumentException("최소 1000원 이상의 금액을 입력해주세요.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("1000원 단위로만 구매 가능합니다.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        int count = money / 1000;

        System.out.println(count + "개를 구매했습니다.");

        return count;
    }
}
