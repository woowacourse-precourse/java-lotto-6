package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {

    final static Validator validator = new Validator();

    public static int validateInputAmount(){
        int amount;
        while(true){
            try{
                String input = inputPurchaseAmount();
                if(!validator.checkAmount(input)){
                    amount = Integer.parseInt(input);
                    break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }
    public static String inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    public static String[] inputLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumber = Console.readLine();
        return lottoNumber.split(",");
    }

    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
