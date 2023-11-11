package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.dto.PayDTO;
import lotto.model.dto.WinningNumDTO;
import lotto.validator.PaymentValidator;
import lotto.validator.WinningNumValidator;

public class InputView {
    private static final String REQEUST_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public static PayDTO readPayment() {
        System.out.println(REQEUST_PAYMENT);
        while (true) {
            try {
                String inputPayment = Console.readLine();
                PaymentValidator.validate(inputPayment);
                return PayDTO.from(inputPayment);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumDTO readWinningNumsAndBonus() {
        String inputWinningNums = readWinningNums();
        String inputBonus = readBonus(inputWinningNums);
        return WinningNumDTO.of(inputWinningNums, inputBonus);
    }

    private static String readBonus(String inputWinningNums) {
        System.out.println(REQUEST_BONUS_NUM);
        while (true) {
            try {
                String inputBonus = Console.readLine();
                WinningNumValidator.validateBonus(inputBonus, inputWinningNums);
                return inputBonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readWinningNums() {
        System.out.println(REQUEST_WINNING_NUMS);
        String inputWinningNums;
        while (true) {
            try {
                inputWinningNums = Console.readLine();
                WinningNumValidator.validateWinningNums(inputWinningNums);
                return inputWinningNums;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
