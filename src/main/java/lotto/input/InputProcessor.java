package lotto.input;

import java.util.Arrays;
import java.util.List;

import static lotto.GameConfig.*;

/*
 * todo
 *  1. 도메인과 관련된 validate 로직들은 LottoGame 또는 다른 클래스로 역할 분리할 필요 있음.
 *  2. 에러 메세지 상수 뽑아내기
 *  3. 메소드, 지역변수명이 역할을 더 잘 나타내도록 수정하기.
 *  4. private methods -> static 여부 결정하기
 * */
public class InputProcessor {
    private final InputReader inputReader;

    public InputProcessor(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Integer getUserPurchaseMoney() {
        String input = inputReader.read();
        validateIsInteger(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = inputReader.read();
        validateWinningNumberInput(input);
        return parseWinningNumberInputToList(input);
    }

    public Integer getBonusNumber() {
        String input = inputReader.read();
        validateIsInteger(input);
        return Integer.valueOf(input);
    }

    public static void validateWinningNumberInput(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);
        Arrays.stream(separatedInput)
                .forEach(InputProcessor::validateIsInteger);
    }

    private static void validateIsInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 정수여야합니다.");
        }
    }


    private List<Integer> parseWinningNumberInputToList(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);
        return Arrays.stream(separatedInput)
                .map(Integer::parseInt)
                .toList();
    }
}
