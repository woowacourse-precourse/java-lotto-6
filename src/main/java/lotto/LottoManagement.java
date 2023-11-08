package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoManagement {
    static final int pricePerPiece=1000;
    private int inputMoney;

    LottoManagement(){
        String stringInput = Console.readLine();
        notIntegerException(stringInput);
        inputMoneyException();
    }

    void notIntegerException(String stringInput){
        try {
            inputMoney = Integer.parseInt(stringInput);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    boolean isDivisible() {
        return inputMoney % pricePerPiece == 0;
    }

    boolean isValidInput(){
        return inputMoney>0;
    }

    void inputMoneyException(){
        if(!isDivisible() || !isValidInput()) throw new IllegalArgumentException();
    }
}
