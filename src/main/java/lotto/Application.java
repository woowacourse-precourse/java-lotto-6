package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // Input 받는 함수 호출
        int purchase = getInput();

        // 로또 리스트 초기화
        List<Lotto> lottoList = new ArrayList<>();

        //로또 리스트 만들기
        generateLotto(purchase, lottoList);

        System.out.println("당첨 번호를 입력해 주세요");
        List<Integer> list = Arrays.stream(Console.readLine().split(",")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        if(!duplicate(list)){

        }


        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus = Integer.parseInt(Console.readLine().trim());


    }

    private static int getInput() {
        int purchase = 0;
        try {
            System.out.println("구입금액을 입력해 주세요.");
            purchase = Integer.parseInt(Console.readLine());
            if (purchase % 1000 != 0) {
                throw new IllegalArgumentException("Purchase amount must be a multiple of 1000.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닙니다");
            purchase = getInput(); // Recursive call to get valid input
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 값을 입력하였습니다");
            purchase = getInput(); // Recursive call to get valid input
        }
        return purchase;
    }

    private static void generateLotto(int purchase, List<Lotto> lottoList){
        for(int i = 0; i < purchase/1000; i++ ){
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        System.out.println("8개를 구매했습니다");
        for (Lotto l: lottoList) {
            l.printLotto();
        }
    }

    private static Boolean duplicate(List<Integer> numbers){
        for ( Integer number : numbers ) {
            if(numbers.contains(number)){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
