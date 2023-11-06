package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lotto.view.outputview.OutputView;

public class InputView {
    private static final Map<String, String> inputMessages = new HashMap<>();

    static {
        inputMessages.put("purchasePrice", "구입금액을 입력해 주세요.");
        inputMessages.put("winningNumbers", "\n당첨 번호를 입력해 주세요.");
        inputMessages.put("bonusNumber", "\n보너스 번호를 입력해 주세요.");
    } // 클래스 처음 로딩 시 실행되는 초기화

    public static Object inputValue(String key, Function<String, Object> numberCreateFunction) {
        while (true) {
            try {
                System.out.println(getInputMessage(key));
                String input = Console.readLine();

                return numberCreateFunction.apply(input);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private static String getInputMessage(String key) {
        return inputMessages.get(key);
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
