package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoPriceValidator;
import lotto.validator.WinningNumberValidator;

public class InputView {
    private static final String READ_LOTTO_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    //가격 입력받아서 가격을 리턴하고 구매할 로또
    public static int readLottoPrice() {
        System.out.println(READ_LOTTO_PRICE_MESSAGE);

        String input = Console.readLine();

        try {
            LottoPriceValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLottoPrice();
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumber() {
        System.out.println();
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        //컴마 예외
        WinningNumberValidator.validateFormat(input);

        //변환
        List<String> list = Arrays.asList(input.split(","));
        //리스트 예외
        WinningNumberValidator.validateDuplicate(list);

        return list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    public static int readBonusNumber(List<Integer> winNumbers) {
        System.out.println();
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        String num = Console.readLine();

        //예외 처리
        BonusNumberValidator.validateBonusNumber(winNumbers, num);

        return Integer.parseInt(num);
    }


}
