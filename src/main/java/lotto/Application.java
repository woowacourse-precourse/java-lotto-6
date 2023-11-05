package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        // TODO: input validation
//        validate(input);

        int purchaseAmount = Integer.parseInt(input);
        // TODO: 구입 금액에 따라 로또 구매하기


        System.out.println("{lottoCnt}"+"개를 구매했습니다.");
        // TODO: 구입한 로또들 출력

        System.out.println("당첨 번호를 입력해 주세요.");
        String winInput = Console.readLine();
        // TODO: winInput validation
//        validate(winInput); // 1 ~ 45 사이의 중복되지 않는 숫자 6개여야함

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        // TODO: bonus number validation
//        validate(bonus); // 1 ~ 45 사이의 숫자여야함

        System.out.println("당첨 통계");
        System.out.println("---");
        // TODO: 당첨 통계 내기
    }
}
