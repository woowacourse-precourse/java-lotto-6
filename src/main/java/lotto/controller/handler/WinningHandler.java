package lotto.controller.handler;

import java.util.List;
import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import static lotto.controller.util.Conversion.makeInt;
import static lotto.controller.util.Conversion.makeIntegerList;

public class WinningHandler {

    private Lotto main;
    private Bonus bonus;

    /**
     * 당첨 번호 6자리를 입력받았을 때 예외가 발생하진 않는지 검사한다.
     * <p>만약 예외가 발생하면 해당 예외와 관련된 문구를 출력한 후 "당첨 번호를 입력해 주세요." 안내메시지부터 다시 출력한다.
     *
     * @param message 안내 메시지
     */
    public void processWinningOngoing(String message) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (hasExceptionWinningOngoing(input));
    }

    /**
     * 보너스 번호 1자리를 입력받고 이를 토대로 당첨 번호+보너스 번호를 생성하는 일련의 과정을 진행하는 동안 예외가 발생하진 않는지 검사한다.
     * <p>만약 예외가 발생하면 해당 예외와 관련된 문구를 출력한 후 "보너스 번호를 입력해 주세요." 안내메시지부터 다시 출력한다.
     *
     * @param message 안내 메시지
     * @param service 서비스 로직 객체
     */
    public void processWinningComplete(String message, LottoService service) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (hasExceptionWinningComplete(input, service));
    }

    private boolean hasExceptionWinningOngoing(String input) {
        try {
            List<Integer> winningMain = makeIntegerList(input);
            main = new Lotto(winningMain);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean hasExceptionWinningComplete(String input, LottoService service) {
        try {
            int winningBonus = makeInt(input);
            bonus = new Bonus(winningBonus);
            service.generateWinning(main, bonus);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

}
