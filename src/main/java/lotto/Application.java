package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해주세요.");
        // 구입 금액을 입력
        int userMoney = getValidMoney();

        // 사용자 게임 수 출력
        System.out.println();
        System.out.println(userMoney / 1000 + "개를 구매했습니다.");
    }

    // 사용자 입력 금액이 유효한지 확인하는 메서드
    public static int getValidMoney() {
        while (true) {
            try {
                int userMoney = getMoney();
                correctMoney(userMoney);
                return userMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 사용자에게 구입 금액을 입력 받는 메서드
    public static int getMoney() {
        return Integer.parseInt(Console.readLine());
    }

    // 사용자 구입 금액이 정확한지 확인하는 메서드
    public static void correctMoney(int userMoney) {
        if (userMoney % 1000 != 0 || userMoney <= 0) {
            // IllegalArgumentException를 발생시키고 오류 메시지 출력
            throw new IllegalArgumentException("[ERROR] 천원 단위로 금액을 입력해 주세요.");
        }
    }
}
