package lotto;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static int CalcCash(int cash) {  // 입력한 금액을 로또로 환산
        int numberOfLotto = 0;
        if (cash % 1000 == 0) {
            numberOfLotto = cash / 1000;
        }
        return numberOfLotto;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현


        // 구매 금액 입력
        System.out.println("구매금액을 입력해 주세요.");
        String Input = Console.readLine();
        int cash = parseInt(Input); // 입력한 현금 금액 ex) 14000

        // 구매한 로또 개수 출력
        System.out.println(CalcCash(cash) + "개를 구매했습니다.");


        //구매한 로또 개수만큼 숫자 뽑아내기






    }
}
