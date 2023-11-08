package lotto.io;

import java.util.Arrays;
import java.util.List;

public class WinningNumberInputManager extends InputManager<List<Integer>> {
    private static WinningNumberInputManager INSTANCE;

    private WinningNumberInputManager() {
    }

    public static WinningNumberInputManager getInstance() {
        if (INSTANCE == null) INSTANCE = new WinningNumberInputManager();
        return INSTANCE;
    }

    @Override
    public List<Integer> input() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputLine = consoleAdapter.readLine();
                return validation(inputLine);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Integer> validation(String input) throws IllegalArgumentException {
        try {
            List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
            numbers.forEach(InputManager::validateNumberRange);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
        }
    }
}
