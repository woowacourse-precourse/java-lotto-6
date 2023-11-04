package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 로또 구입 금액 입력 받기
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int lottoBought = Integer.parseInt(Console.readLine());

                // 예외 처리
                int lottoBought1000 = lottoBought % 1000;
                if (lottoBought1000 != 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1,000원 단위로 입력해 주세요.");
            }
        }

        // TODO: 로또 번호 출력

        // TODO: 당첨 번호 입력 받기

        // TODO: 보너스 번호 입력 받기

        // TODO: 로또 번호와 당첨 번호 비교

        // TODO: 당첨 통계 출력

        // TODO: 수익률 계산

        // TODO: 수익률 출력
    }
}
