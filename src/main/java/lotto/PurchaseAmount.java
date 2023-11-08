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

    // 입력값이 숫자인지 확인하여 변환
    private int convertToInt(String input_amount){
        try {
            return Integer.parseInt(input_amount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다. 1000원 단위의 자연수를 입력해주세요.");
        }
    }

    // 구입금액이 1000원 단위인지 확인
    public void checkUnit1000(int amount){
        if(amount < 0 || amount % 1000 != 0){
            throw new IllegalArgumentException("구입금액은 1000원 단위의 자연수로 입력해야 합니다.");
        }
    }

    public void inputAmount(){
        while(true) {
            String input_amount = readLine();
            try {
                int converted_amount = convertToInt(input_amount);
                checkUnit1000(converted_amount);
                amount = converted_amount;
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[Error] " + e.getMessage());
            }
        }
    }
}
