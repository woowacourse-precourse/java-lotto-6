package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.dto.PayDTO;

public class BeforeScreen {
    private static final String REQEUST_PAYMENT= "구입금액을 입력해 주세요.";
    public static PayDTO readPayment(){
        System.out.println(REQEUST_PAYMENT);
        String pay = Console.readLine();
        return PayDTO.from(pay);
    }
}
