package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseAmount {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void printInputAmountMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    // 구입금액이 1000원 단위인지 확인
    public void checkUnit1000(int amount){
        if(amount < 0 || amount % 1000 != 0){
            throw new IllegalArgumentException("구입금액은 1000원 단위의 자연수로 입력해야 합니다.");
        }
    }

    public void inputAmount(String input_amount){
        int converted_amount = CommonFunction.convertToInt(input_amount);
        checkUnit1000(converted_amount);
        amount = converted_amount;
    }
}
