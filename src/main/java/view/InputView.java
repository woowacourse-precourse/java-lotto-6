package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String PURCHASE_MESSAGE =
            "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_MESSAGE =
            "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE =
            "\n보너스 번호를 입력해 주세요.";

    public static int inputPurchasePrice(){
        System.out.println(PURCHASE_MESSAGE);

        int purchasePrice = Integer.parseInt(readLine());
        if(purchasePrice % 1000 != 0 ){
            throw new IllegalArgumentException();
        }
        return purchasePrice;
    }

    public static List<Integer> inputWinningNumber(){
        System.out.println(WINNING_NUMBER_MESSAGE);

        String[] numbers = readLine().split(",");

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(readLine());
    }

}
