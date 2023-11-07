package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String ERROR_MESSAGE_NUMBER = "[ERROR] 숫자 형식이 아닙니다.";
    private static final String ERROR_MESSAGE_NUMBERS = "[ERROR] 숫자 리스트 형식이 아닙니다.";

    public void showAskPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showAskWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showAskBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    /**
     * 숫자 리스트를 입력받는 함수
     *
     * @return : 숫자 리스트
     * @throws NumberFormatException : 숫자 리스트로 변환 실패한 경우
     */
    public List<Integer> askNumbers() throws NumberFormatException {
        List<Integer> numbers;

        try {
            String input = Console.readLine();
            String[] split = input.split(",", -1);
            Stream<Integer> integerStream = Arrays.stream(split).map(Integer::parseInt);
            numbers = integerStream.collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE_NUMBERS);
        }
        return numbers;
    }

    /**
     * 숫자를 입력받는 함수
     *
     * @return : 숫자
     * @throws NumberFormatException : 숫자로 변환 실패한 경우
     */
    public int askNumber() throws NumberFormatException {
        int number;

        try {
            String input = Console.readLine();
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE_NUMBER);
        }
        return number;
    }
}