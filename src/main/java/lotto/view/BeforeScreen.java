package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.dto.PayDTO;

public class BeforeScreen {
    private static final String REQEUST_PAYMENT= "구입금액을 입력해 주세요.";
    private static final String INFO_OF_NUM_OF_LOTTOS = "개를 구매했습니다.";
    public static PayDTO readPayment(){
        System.out.println(REQEUST_PAYMENT);
        String pay = Console.readLine();
        return PayDTO.from(pay);
    }

    public static void printPurchasedLottos(int numberOfLottos, String resultOfPurchasedLottos) {
        System.out.println(String.valueOf(numberOfLottos) + INFO_OF_NUM_OF_LOTTOS);
        System.out.println(resultOfPurchasedLottos);
    }
}
