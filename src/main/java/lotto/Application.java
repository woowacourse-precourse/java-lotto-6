package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        int inputMoney = inputMoney();
        int count = moneyReplaceCount(inputMoney);
        System.out.println("\n"+count+"개를 구매했습니다.");
        Map<Integer, List<Integer>> integers = generateAndDisplayNumbers(count);
        printGenerateAndDisplayNumbers(integers);


    } // main

    public static Integer inputMoney(){ // 사용자가 뽑고 싶은 만큼 돈 투입

        System.out.println("구입금액을 입력해 주세요.");
        Integer money = null;

        try {
            money = Integer.parseInt(readLine());
            money = moneyDiscrimination(money);
        } catch (NumberFormatException | NullPointerException e) {
            money = inputMoney();
        } catch (IllegalArgumentException e) {
            money = inputMoney();
        }

        return money;
    } // inputMoney

    public static List<Integer> pickUniqueNumber(){ // 복권의 랜덤한 값을 출력한 후 반환
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Integer moneyDiscrimination(Integer money){ // 입력한 돈이 맞게 들어왔는지 검증하는 메소드
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("잘못된 금액을 투입하셨습니다.");
        }
        if(money == null){
            throw new NumberFormatException("유효하지 않은 숫자입니다. 다시 시도하세요.");
        }
        return money;
    } // pickUniqueNumber

    public static int moneyReplaceCount(int money){ // 입력된 돈을 횟수로 치환하는 메소드
        return money/1000;
    } // moneyReplaceCount

    public static Map<Integer, List<Integer>> generateAndDisplayNumbers(int count){ // 횟수만큼 복권을 Map 객체에 저장

        Map<Integer, List<Integer>> pickNumbers = new Hashtable<>();

        for(int i=1; i<=count; i++){
            pickNumbers.put(i, pickUniqueNumber());
        }

        return pickNumbers;
    }
    
    public static void printGenerateAndDisplayNumbers(Map<Integer, List<Integer>> pickNumbers){ // 횟수만큼 저장한 복권을 출력

        pickNumbers.forEach((key, value) -> {
            Collections.sort(value);
            System.out.println(value);
        });

    }
    
}
