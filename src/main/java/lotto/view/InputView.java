package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestMoneyFromUser(){
        try{
            String input = Console.readLine();
            validationBlankException(input);
            System.out.println();
            return input.trim();
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액 입력은 필수 사항입니다.");
            return requestMoneyFromUser();
        }
    }

    public String requestWinningLottoFromUser(){
        try{
            String input = Console.readLine();
            validationBlankException(input);
            return input;
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호 입력은 필수 사항입니다.");
            return requestWinningLottoFromUser();
        }
    }

    public String requestBonusNumberFromUser(){
        try{
            String input = Console.readLine();
            System.out.println();
            validationBlankException(input);
            return input.trim();
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 보너스 번호 입력은 필수 사항입니다.");
            return requestBonusNumberFromUser();
        }
    }

    private void validationBlankException(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException();
        }
    }
}
