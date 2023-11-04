package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.dto.PayDTO;
import lotto.model.dto.WinningNumDTO;

public class InputView {
    private static final String REQEUST_PAYMENT= "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUM = "보너스 번호를 입력해 주세요.";
    public static PayDTO readPayment(){
        System.out.println(REQEUST_PAYMENT);
        String pay = Console.readLine();
        return PayDTO.from(pay);
    }

    public static WinningNumDTO readWinningNums() {
        System.out.println(REQUEST_WINNING_NUMS);
        String win = Console.readLine();
        System.out.println(REQUEST_BONUS_NUM);
        String bonus = Console.readLine();
        return WinningNumDTO.of(win, bonus);
    }
 }
