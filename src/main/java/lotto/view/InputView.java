package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    //당첨번호를 입력받는 메서드
    //파싱하는 기능을 포함하고 있다. 리팩토링여부 고민
    //유효성 검사 추가해야된다
    public List<Integer> winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        String input =  Console.readLine();

        List<Integer> numbers = Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        return numbers;
    }

    //보너스 번호를 입력받는 메서드
    //파싱하는 기능을 포함하고 있다. 리팩토링여부 고민
    public int bonusNumber() {
        System.out.printf(INPUT_BONUS_NUMBER);
        String input =  Console.readLine();
        return Integer.parseInt(input);
    }

    //로또 구입금액을 입력받는 메서드
    //파싱하는 기능을 포함하고 있다. 리팩토링여부 고민
    public int lottoPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String input =  Console.readLine();
        return Integer.parseInt(input);
    }
}
