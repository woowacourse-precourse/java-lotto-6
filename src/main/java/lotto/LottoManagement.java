package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoManagement {
    static final int pricePerPiece=1000;
    private final int inputMoney;

    LottoManagement(){
        inputMoney = Integer.parseInt(Console.readLine());
        inputMoneyException();
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
