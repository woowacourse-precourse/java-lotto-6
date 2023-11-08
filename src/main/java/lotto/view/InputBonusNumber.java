package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputBonusNumber {

    private static final String INPUT_BONUSNUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int inputBonusNumber(){
        String input = inputBonusNumberView();
        validateInput(input);
        return Integer.parseInt(input);
    }

    private String inputBonusNumberView(){
        System.out.println(INPUT_BONUSNUMBER_MESSAGE);
        return Console.readLine();
    }

    private void validateInput(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력값이 유효한 숫자가 아닙니다.");
        }
    }

}
