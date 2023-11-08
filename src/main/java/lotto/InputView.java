package lotto;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public static int getPurchaseAmount(){
        System.out.println("구입 금액을 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static String getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static Number getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        try{
            int number = Integer.parseInt(Console.readLine());
            Number bonusNumber = new Number(number);
            return bonusNumber;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }

    }

}
