package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현 
        int amountOfLotto = setAmountOfLotto(-1);
        String[] winningNumber = setWinningNumber();
        int bonusNumber = setBonusNumber(-1);


        System.out.println("amountOfLotto " + amountOfLotto);
        System.out.println("winningNumber " + winningNumber);
        System.out.println("bonusNumber " + bonusNumber);
    }

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
        if(amountOfLotto % 1000 != 0){
            throw new IllegalArgumentException("로또는 1000원 단위로 적어야합니다.");
        }
    }
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
        for (String number : numbers) {
            isValidWinningNumbers(number);
        }
        return numbers;
    }
    public static int setBonusNumber(int initialNum){
        while (initialNum == -1) {
            try {
                initialNum = isValidWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return initialNum;
    }
    private static int isValidWinningNumbers(String number) {
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
