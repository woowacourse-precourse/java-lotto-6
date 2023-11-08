package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Bonus;
import lotto.domain.WinningLottoNumbers;

public class InputView {

    private static final String GET_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String GET_WINNING_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요";
    private static final String GET_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요";

    public int getPurchaseAmount() {

        System.out.println(GET_PURCHASE_AMOUNT_MESSAGE);

        String input = Console.readLine();

        validateNumber(input);

        validateDivide(input);

        return Integer.parseInt(input) / 1000;
    }

    public WinningLottoNumbers getWinningLottoNumbers() {

        System.out.println(GET_WINNING_LOTTO_NUMBERS_MESSAGE);

        String input = Console.readLine();

        for (String inputSplit : input.split(",")) {
            validateNumber(inputSplit);
        }

        return new WinningLottoNumbers(
                Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList()));

    }

    public Bonus getBonusLottoNumber() {

        System.out.println(GET_BONUS_LOTTO_NUMBER_MESSAGE);

        String input = Console.readLine();

        return new Bonus(Integer.parseInt(input));

    }

    private void validateNumber(String input) {

        for (char eachNumber : input.toCharArray()) {

            if (eachNumber < 48 || eachNumber > 57) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            }

        }

    }

    private void validateDivide(String input){

        if(Integer.parseInt(input)%1000 !=0){
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지지 않습니다.");
        }

    }

}
