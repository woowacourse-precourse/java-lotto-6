package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "\n보너스 번호를 입력해 주세요";
    private static final String DELIMITER = ",";

    private static List<Integer> lottoNumbers = new ArrayList<>();


    public static int setPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        return Integer.parseInt(amount);
    }

    public static List<Integer> setLottoNumber() {

        lottoNumbers = new ArrayList<>();
        System.out.println(LOTTO_NUMBER_MESSAGE);
        stringToList(Console.readLine(), lottoNumbers);
        return lottoNumbers;

    }

    private static void stringToList(String number, List<Integer> lottoNumbers) {
        for (String lotto : number.split(DELIMITER)) {
            lottoNumbers.add(Integer.parseInt(lotto));
        }
    }


    public static int setBonusBall() {
        System.out.println(BONUS_BALL_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}
