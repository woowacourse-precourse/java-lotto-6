package lotto;

import java.util.InvalidPropertiesFormatException;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class StartLotto {
    private List<Lotto> lottoList;
    private int purchasePrice;
    private List<Integer> randomNumbers;
    private int bonusNumber;

    public StartLotto() {
        this.purchasePrice = 0;
        this.bonusNumber = 0;
    }

    private void printMessageForInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void inputPurchasePrice() {
        String purchasePrice = Console.readLine();

        checkIsInteger(purchasePrice);
        checkIs1000wonUnit();
    }

    private void checkIsInteger(String purchasePrice) {
        try{
            this.purchasePrice = Integer.parseInt(purchasePrice);
        } catch(NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private void checkIs1000wonUnit() {
        if(this.purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
