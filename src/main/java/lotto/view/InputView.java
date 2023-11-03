package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

public class InputView {
    private OutputView outputView;
    private InputException inputException;
    public InputView(){
        outputView = new OutputView();
        inputException = new InputException();
    }
    public int inputAmount(){
        outputView.amountMessage();
        String amount = Console.readLine();
        int money = 0;
        try {
            money = toInt(amount);
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return inputAmount();
        }
        inputException.checkThousandUnit(money);
        return money;
    }
    public String winningNumber(){
        outputView.winningNumberMessage();
        return Console.readLine();
    }
    public int bonusNumber(){
        outputView.bonusNumberMessage();
        return Integer.parseInt(Console.readLine());
    }
    private int toInt(String amount){
        if(!amount.matches("^[0-9]*$")){
            throw new NumberFormatException("[ERROR] 숫자를 입력해 주세요.");
        }
        return Integer.parseInt(amount);
    }
}
