package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

public class BonusNumber {
    private final OutputView outputView = new OutputView();
    public void add(WinningNumbers winningNumbers){
        outputView.inputBonusNumber();
        while(true){
            try{
                String bonusBall = Console.readLine();
                if(checkValid(bonusBall)){
                    winningNumbers.add(stoi(bonusBall));
                    break;
                }
            }   catch (IllegalArgumentException e){
                System.out.println("[ERROR] 다시 입력하세요");
            }
        }
    }

    private boolean checkValid(String bonusBall) {
        if(Integer.parseInt(bonusBall) > 0 && Integer.parseInt(bonusBall) < 46){
            return true;
        }
        throw new IllegalArgumentException();
    }

    private int stoi(String input){
        return Integer.parseInt(input);
    }
}
