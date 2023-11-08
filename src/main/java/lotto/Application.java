package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int total_price = Integer.parseInt(Console.readLine());
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
        int bonus_number = Integer.parseInt(Console.readLine());


        /**
         * 당첨 번호 비교
         * CreateLottoNumber.compare -> Lotto.compare -> double count 반환 -> CreateLottoNumber.Double 리스트에 저장
         */
        createLottoNumber.compare(winning_number, bonus_number);
        Result result = new Result();
        result.calculate(createLottoNumber.count);
        result.result();

    }
}
