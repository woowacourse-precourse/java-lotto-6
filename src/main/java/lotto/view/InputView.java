package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    static private final String READ_LOTTO_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    static private final String READ_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static private final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    /**
     * 1) [로또 구매 금액] 입력받기 관련
     */
    static private void printReadMessage(String message) {
        System.out.println(message);
    }

    //가격 입력받아서 가격을 리턴하고 구매할 로또
    public int readLottoPrice() {
        //메시지
        printReadMessage(READ_LOTTO_PRICE_MESSAGE);

        String input = Console.readLine();

        validateLottoPrice(input);
        return Integer.parseInt(input);
    }

    private void validateLottoPrice(String input) throws IllegalArgumentException {
        //1) 숫자 입력 아니면 예외
        for (char num : input.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("[ERROR] 구매 금액에는 숫자만 입력해야 합니다. ");
            }
        }

        //2) 숫자 범위 어긋난 경우 예외
        int input_number = Integer.parseInt(input);
        if (input_number < 1000 || input_number <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액의 범위는 1000원 이상이어야 합니다.");
        }

        //3) 1000원 단위로 나누어 떨어지지 않아도 예외
        if (input_number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR} 구매 금액은 1000원 단위로 작성되어야 합니다.");
        }

        //4) 불필요한 띄어쓰기, 공백 포함 시 예외
        for (char num : input.toCharArray()) {
            if (num == ' ') {
                throw new IllegalArgumentException("[ERROR] 구매 금액에 공백이 포함되면 안됩니다.");
            }
        }
    }


    /**
     * 4. 당첨 번호 입력 기능
     */

    public List<Integer> readWinningNumber() {
        System.out.println();

        printReadMessage(READ_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        //컴마 예외
        validateWinNumberComma(input);

        //변환
        List<String> list = Arrays.asList(input.split(","));
        //리스트 예외
        validateWinNumberList(list);

        return list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    static void validateWinNumberComma(String input) throws IllegalArgumentException {
        //1) 처음부터 컴마 입력 시
        if (input.charAt(0) == ',') {
            throw new IllegalArgumentException("[ERRPR] 당첨 번호에 처음부터 쉼표(,) 가 입력되면 안됩니다.");
        }

        //2) 중간 중복 컴마
        if (input.contains(",,")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 쉼표가 포함되면 안됩니다.");
        }

        //3) 끝에 컴마만 입력 시
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 끝에 쉼표(,)가 입력되면 안됩니다. ");
        }
    }

    static void validateWinNumberList(List<String> list) throws IllegalArgumentException {
        if (list.size() != 6) {
            throw new IllegalArgumentException();
        }

        //1) 숫자 아닌 값 포함 시 예외

        //2) 당첨 번호 범위 벗어난 경우

        //3) 공백 포함 시 예외

        //4) 당첨 번호와 중복 시 예외

        //5) 당첨 번호 개수가 6개 아닐 경우 예외
    }

    /**
     * 5. 보너스 번호 입력
     */

    public int readBonusNumber() {
        System.out.println();
        printReadMessage(READ_BONUS_NUMBER_MESSAGE);
        String num = Console.readLine();

        //예외 처리
        validateBonusNumber(num);
        return Integer.parseInt(num);
    }

    static void validateBonusNumber(String input) throws IllegalArgumentException {
        //1) 숫자 아닌 값 예외

        //2) 범위 벗어난 값 예외

        //3) 공백 포함 시 예외

        //4) 앞선 6개 당첨 번호와 중복 시 예외

    }

}
