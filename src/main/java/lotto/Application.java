package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static int count = 0;

    public static void main(String[] args) {
        // 입력 메소드 실행
        int purchaseMoney = purchaseMoney();
        List<Lotto> lottoNumbers = Output.createLottoNumbers(count);
        List<Integer> winNumbers = winNumber();
        int addNum = addNum();
        List<Integer> prizeCount = Output.checkList(lottoNumbers, winNumbers, addNum);
        Output.prizeRate(prizeCount, purchaseMoney);


        System.out.println(purchaseMoney);
        System.out.println(lottoNumbers);
        System.out.println(winNumbers);
        System.out.println(addNum);

    }

    // 로또 구입 금액 입력
    private static int purchaseMoney(){
        int input = 0;
        boolean validInput = false;

        while(!validInput){
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input = Integer.parseInt(readLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        count = input / 1000;

        System.out.println();
        return input;
    }

    // 당첨 번호 입력
    private static List<Integer> winNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();

        List<Integer> numbers = new ArrayList<>();
        List<String> strNumbers = Arrays.asList(input.split(","));

        for(int i = 0; i < strNumbers.size(); i++){
            numbers.add(Integer.parseInt(strNumbers.get(i)));
        }

        System.out.println();
        return numbers;
    }

    // 보너스 번호 입력
    private static int addNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int input = Integer.parseInt(readLine());

        System.out.println();
        return input;
    }
}
