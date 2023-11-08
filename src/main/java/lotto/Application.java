package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        /**
         * 구입 금액 입력
         */
        System.out.println("구입금액을 입력해 주세요.");
        int total_price = Integer.parseInt(Console.readLine());
        /**
         * 구입 번호 출력
         */
        CreateLottoNumber createLottoNumber = new CreateLottoNumber(total_price);

        /**
         * 당첨 번호 입력
         */
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winning_number = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken().trim());
            if(!winning_number.contains(number)) {
                winning_number.add(number);
            }
        }

        /**
         * 보너스 번호 입력
         */
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_number = Integer.parseInt(Console.readLine());



        /**
         * 구입 번호, 당첨 번호 비교
         */
        createLottoNumber.compare(winning_number, bonus_number);
        Result result = new Result(total_price);
        result.calculate(createLottoNumber.count);
        result.result();
    }
}
