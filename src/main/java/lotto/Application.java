package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        int inputMoney = inputMoney(money);

        int count = moneyReplaceCount(inputMoney);
        System.out.println("\n"+count+"개를 구매했습니다.");
        Map<Integer, List<Integer>> userCountRandomLotto = generateAndDisplayNumbers(count);
        printGenerateAndDisplayNumbers(userCountRandomLotto);

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = readLine();
        List<Integer> pickWinnerNumber = inputWinningNumberVerification(inputWinningNumber(numbers));
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        List<Integer> bonusNum = inputBounsNumber(pickWinnerNumber, bonusNumber);
        System.out.println("bonusNum = " + bonusNum);


    } // main

    public static Integer convertStringToInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static List<Integer> pickUniqueNumber(){ // 복권의 랜덤한 값을 출력한 후 반환
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Integer inputMoney(String money){ // 사용자가 뽑고 싶은 만큼 돈 투입
        while (true) {
            try {
                Integer userMoney = convertStringToInt(money);
                return userMoney; // 유효한 입력이면 반환하고 메서드 종료
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 시도하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            money = readLine(); // 새로운 입력을 받습니다.
        }
    } // inputMoney



    public static Integer moneyDiscrimination(Integer money){ // 입력한 돈이 맞게 들어왔는지 검증하는 메소드
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 투입하셨습니다. 다시 시도하세요.");
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
    } // generateAndDisplayNumbers
    
    public static void printGenerateAndDisplayNumbers(Map<Integer, List<Integer>> pickNumbers){ // 횟수만큼 저장한 복권을 출력

        pickNumbers.forEach((key, value) -> {
            Collections.sort(value);
            System.out.println(value);
        });

    } // printGenerateAndDisplayNumbers

    public static List<Integer> inputWinningNumber(String numbers){ // 사용자가 입력하는 당첨금액을 콤마를 제거한 숫자로만 만들기
        List<Integer> intNumbers = new ArrayList<>();

        while(true) {
            String[] strNumbers = numbers.split(",");
            boolean isValidInput = checkWinningNumberValidity(strNumbers, intNumbers);


            if(isValidInput){
                break;
            }

            numbers = readLine();
        }

        return intNumbers;
    } // inputWinningNumber

    public static boolean checkWinningNumberValidity(String[] strNumbers, List<Integer> intNumbers){ // 당첨번호 예외처리
        boolean isValidInput = true;

        for (String strNumber : strNumbers) {
            try {
                intNumbers.add(convertStringToInt(strNumber.trim()));
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 시도하세요.");
                isValidInput = false;
                break;
            }
        }

        return isValidInput;
    } // checkWinningNumberValidity

    public static List<Integer> inputWinningNumberVerification(List<Integer> inputWinningNumber){ // 사용자가 입력하는 당첨금액이 맞게 입력했는지 검증하는 메소드
        Lotto lotto = null;

        while(true) {
            try {
                lotto = new Lotto(inputWinningNumber);
                return lotto.getNumbers();
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("[ERROR] 1~45까지 중 6자리를 입력해주세요");
            }

            String str = readLine();
            inputWinningNumber = inputWinningNumber(str);
        }

    } // inputWinningNumberVerification

    public static List<Integer> inputBounsNumber(List<Integer> winnerNumber, String bonusNumber){ // 보너스 번호 입력
        while(true) {
            try {
                int bonusNum = convertStringToInt(bonusNumber);
                if (!userInputNumber(bonusNum)) {
                    throw new IllegalArgumentException();
                }
                winnerNumber.add(bonusNum);
                return winnerNumber;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 시도하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45까지 중 6자리를 입력해주세요");
            }
            String str = readLine();
            bonusNumber = str;
        }
    } // inputBounsNumber
    
    public static boolean userInputNumber(Integer num){ // 당첨번호, 보너스 번호가 1 ~ 45만 입력했는지 검증 메소드

        if(num <= 0 || num > 45){
            return false;
        }
        return true;
    } // userInputNumber

}
