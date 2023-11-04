package lotto.view;

import java.util.List;

import static lotto.constant.PrintMessage.*;

public class OutputView {
    public static void inputPurchaseAmountMessage(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printIssuedLottoMessage(int issuedLottoCount){
        System.out.println("\n"+issuedLottoCount+PRINT_ISSUED_LOTTO);
    }

    public static void printIssuedLotto(List<Integer> issuedLottoNumber){
        System.out.println(issuedLottoNumber);
    }

    public static void errorMessage(String s){
        System.out.println(s);
    }
}
