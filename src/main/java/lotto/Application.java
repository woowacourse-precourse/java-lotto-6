package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현 
        int amountOfLotto = setAmountOfLotto(-1);
        List<List<Integer>> LottoNumbers = generateLottoNumbers(amountOfLotto);
        System.out.println("amountOfLotto " + amountOfLotto + "로또 번호입니다.\n");
        for(List<Integer> numbers : LottoNumbers){
            System.out.println(numbers);
        }

        Lotto winningNumber = setWinningLotto();
        int bonusNumber = getBonusNumber(winningNumber);
        System.out.println("bonusNumber " + bonusNumber);
        System.out.println("winningNumber " + winningNumber.toString());
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
            amount = validateInput(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return -1; // 유효하지 않은 입력에 대해 -1 반환
    }
    public static int validateInput(int amountOfLotto){
        if(amountOfLotto <= 0 || amountOfLotto % 1000 != 0){
            throw new IllegalArgumentException("로또는 1000원 단위로 적어야합니다.");
        }
        return amountOfLotto / 1000;
    }
    public static List<List<Integer>> generateLottoNumbers(int amount){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < amount ; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(numbers);
        }
        
        return lottoNumbers;
    }
    
    //당첨 번호 입력받기
    public static Lotto setWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        return new Lotto(winningNumbers);
    }
    private static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.print("당첨 번호를 입력하세요 (쉼표로 구분된 6개의 숫자): \n");
                List<Integer> winningNumbers = parseNumbers(Console.readLine());
                new Lotto(winningNumbers); // 당첨 번호 유효성 검사
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Lotto 생성 시 발생하는 예외 메시지 출력
            }
        }
    }
    private static int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                System.out.print("보너스 번호를 입력하세요 (1부터 45 사이의 숫자): ");
                int bonusNumber = setBonusNumber(winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString.trim());
                numbers.add(number);
                // isValidBonusNumber(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] : 올바른 숫자 형식이 아닙니다.");
            }
        }
        return numbers;
    }
    //보너스 번호 입력받기
    private static int setBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                System.out.print("보너스 번호를 입력하세요 (1부터 45 사이의 숫자): ");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                isValidBonusNumber(bonusNumber);    
                winningNumbers.contains(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자 형식이 아닙니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void isValidBonusNumber(int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
}

    


}
