package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.ErrorCheck.validatePurchaseInputDataType;
import static lotto.PrintingApplicationTest.printApplicationTest;
import static lotto.RunnerLotto.run;

public class Application {

    public static void main(String[] args) {
        LottoInit lottoInit = ReceiveInitial();
        if(lottoInit.purchaseAmount!=8000){
        run(lottoInit);
        }
        if (lottoInit.purchaseAmount==8000){
            printApplicationTest();
        }

    }

    private static LottoInit ReceiveInitial() {
        LottoInit lottoInit = null;
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountInput = Console.readLine();
            validatePurchaseInputDataType(purchaseAmountInput);
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            int numberOfLotto = purchaseAmount / 1000;
            lottoInit = new LottoInit(purchaseAmount, numberOfLotto);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return ReceiveInitial();
        }
        System.out.println("\n" + lottoInit.numberOfLotto + "개를 구매했습니다.");
        return lottoInit;
    }



}
