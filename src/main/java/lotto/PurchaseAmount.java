package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseAmount {
    private static int amount;

    public int getAmount() {
        return amount;
    }

    public void print_inputAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void validate(String input_amount){
        try {
            amount = Integer.parseInt(input_amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다. 1000원 단위의 자연수를 입력해주세요.");
        }

        if(amount < 0 || amount % 1000 != 0){
            throw new IllegalArgumentException("구입금액은 1000원 단위의 자연수로 입력해야 합니다.");
        }
    }
    public void inputAmount(){
        String input_amount = readLine();
        validate(input_amount);
    }
}
