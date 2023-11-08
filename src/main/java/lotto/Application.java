package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        long total_price = 0;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                total_price = Integer.parseInt(Console.readLine());
                break;  // 정상적으로 정수가 입력되면 루프를 빠져나갑니다.
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]");
            }
        }

        /**
         * 번호 출력
         */
        CreateLottoNumber createLottoNumber = new CreateLottoNumber(total_price);

        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winning_number = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken().trim());
            if(!winning_number.contains(number)) {
                winning_number.add(number);
            }
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus_number = Integer.parseInt(Console.readLine());

        /**
         * 당첨 번호 비교
         */
        createLottoNumber.compare(winning_number, bonus_number);
        Result result = new Result(total_price);
        result.calculate(createLottoNumber.count);
        result.result();
    }
}
