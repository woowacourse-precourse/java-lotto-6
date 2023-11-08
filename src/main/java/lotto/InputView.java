package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public static int getPurchaseAmount(){
        int purchaseAmount=-1;
        while(purchaseAmount<1000){
            System.out.println("구입 금액을 입력하세요.");
            try{
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount<1000) {
                    throw new IllegalArgumentException();
                }
                if (purchaseAmount%1000!=0) {
                    throw new IllegalArgumentException();
                }
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR]유효하지 않은 입력값입니다.");
            }
        }
        return purchaseAmount;
    }

    public static String getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int getBonusNumber(List<Integer> winningNumbers){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber=-1;
        while(bonusNumber<0){
            try{
                bonusNumber = Integer.parseInt(Console.readLine());;
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException();
                }
                if(winningNumbers.contains(bonusNumber)){
                    throw new IllegalArgumentException();
                }
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR]유효하지 않은 입력값입니다.");
            }
        }
        return bonusNumber;
    }

}
