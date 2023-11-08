package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private static final int MIN_NUMBER= 1;
    private static final int MAX_NUMBER= 45;

    public static String purchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static List<Integer> winningNumberInput(){
        System.out.println("당첨번호를 입력해 주세요.");

        String input = Console.readLine();
        System.out.println();

        String[] winningStringNumbers = input.split(",");

        List<Integer> winningNumbers = new ArrayList<>();

        for(int i=0;i<6;i++){
            try{
                int winningNumber = Integer.parseInt(winningStringNumbers[i]);
                checkRange(winningNumber);
                winningNumbers.add(winningNumber);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
            }

        }

        return winningNumbers;
    }

    public static int bonusNumberInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
        try{
            int bounsNumber = Integer.parseInt(Console.readLine());
            checkRange(bounsNumber);
            System.out.println();

            return bounsNumber;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }

    public static void checkRange(int number){
        if(number<1 || number>45){
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45입니다.");
        }
    }

}
