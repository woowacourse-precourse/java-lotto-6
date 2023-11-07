package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputPurchaseAmountView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public int inputAmountView(){
        String input = inputPurchaseAmount();
        validateInput(input);
        return Integer.parseInt(input);
    }

    public String inputPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    private void validateInput(String input){
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력값이 유효한 숫자가 아닙니다.");
        }
    }
}
