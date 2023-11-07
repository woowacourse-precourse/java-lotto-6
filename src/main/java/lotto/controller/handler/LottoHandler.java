package lotto.controller.handler;

import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import static lotto.controller.util.Conversion.makeInt;

public class LottoHandler {

    /**
     * 로또 구입 금액을 입력받고 적절한 장수의 로또를 자동발행하는 일련의 과정을 진행하는 동안 예외가 발생하진 않는지 검사한다.
     * <p>만약 예외가 발생하면 해당 예외와 관련된 문구를 출력한 후 "구입 금액을 입력해 주세요." 안내메시지부터 다시 출력한다.
     *
     * @param message 안내 메시지
     * @param service 서비스 로직 객체
     */
    public void process(String message, LottoService service) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (hasException(input, service));
    }

    private boolean hasException(String input, LottoService service) {
        try {
            int price = makeInt(input);
            service.buyLotteries(price);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

}
