package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 입력 메소드 실행
        int purchaseMoney = purchaseMoney();
        List<Integer> winNumbers = winNumber();
        int addNum = addNum();

        System.out.println(purchaseMoney);
        System.out.println(winNumbers);
        System.out.println(addNum);

    }

    // 로또 구입 금액 입력
    public static int purchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int input = Integer.parseInt(readLine());

        return input;
    }

    // 당첨 번호 입력
    public static List<Integer> winNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();

        List<Integer> numbers = new ArrayList<>();
        List<String> strNumbers = Arrays.asList(input.split(","));

        for(int i = 0; i < strNumbers.size(); i++){
            numbers.add(Integer.parseInt(strNumbers.get(i)));
        }

        return numbers;
    }

    // 보너스 번호 입력
    public static int addNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int input = Integer.parseInt(readLine());

        return input;
    }

}
