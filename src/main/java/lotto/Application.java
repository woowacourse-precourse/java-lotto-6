package lotto;

import java.util.Set;
import java.util.HashSet;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현 
        int amountOfLotto = setAmountOfLotto(-1);
        String[] winningNumber = setWinningNumber();
        int bonusNumber = setBonusNumber(-1, winningNumber);


        System.out.println("amountOfLotto " + amountOfLotto);
        System.out.println("winningNumber " + winningNumber);
        System.out.println("bonusNumber " + bonusNumber);
    }
    //금액 입력받기
    public static int setAmountOfLotto(int amountOfLotto){
        while (amountOfLotto == -1) {
            amountOfLotto = parseAmount(Console.readLine());
        }
        return amountOfLotto;
    }
    private static int parseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            validateInput(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return -1; // 유효하지 않은 입력에 대해 -1 반환
    }
    public static void validateInput(int amountOfLotto){
        if(amountOfLotto <= 0 || amountOfLotto % 1000 != 0){
            throw new IllegalArgumentException("로또는 1000원 단위로 적어야합니다.");
        }
    }
    //당첨 번호 입력받기
    public static String[] setWinningNumber() {
        String[] winningNumber = null;
        while (winningNumber == null) {
            try {
                System.out.print("당첨 번호를 입력하세요 (쉼표로 구분된 6개의 숫자): ");
                winningNumber = validateWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 잘못된 입력에 대해 다시 입력을 요청
            }
        }
        return winningNumber;
    }
    private static String[] validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분된 6개의 숫자여야 함");
        }
        Set<Integer> uniqueNumber = new HashSet<>();        
        for (String number : numbers) {
            int num = isValidWinningNumbers(number);
            uniqueNumber = isDuplicateNumber(num, uniqueNumber);
        }
        return numbers;
    }
    //보너스 번호 입력받기
    public static int setBonusNumber(int initialNum, String[] winningNumbers){
        Set<Integer> uniqueNumber = new HashSet<>();
        for(int i = 0; i < 6; i++){
            uniqueNumber.add(Integer.parseInt(winningNumbers[i]));
        }
        while (initialNum == -1) {
            try {
                initialNum = isValidWinningNumbers(Console.readLine());
                isDuplicateNumber(initialNum, uniqueNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                initialNum = -1;
            }
            
        }
        return initialNum;
    }
    //중복 검사
    public static Set<Integer> isDuplicateNumber(int num, Set<Integer> uniqueNumber){
        if(!uniqueNumber.add(num)){
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        return uniqueNumber;
    }
    //당첨번호 범위와 숫자인지 검사하기
    static int isValidWinningNumbers(String number) {
        int num = 0;
        try {
            num = Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("모든 번호는 숫자여야 함");
        }
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 함");
        }
        return num;
    } 



}
