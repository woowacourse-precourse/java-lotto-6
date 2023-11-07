package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import io.output.Writer;
import java.util.function.Supplier;
import lotto.controller.dto.input.BuyLottosDto;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.controller.dto.input.builder.DrawLottosDtoBuilder;
import lotto.view.component.input.InputBonusNumberComponent;
import lotto.view.component.input.InputLottoNumbersComponent;
import lotto.view.component.input.InputMoneyComponent;
import lotto.view.component.output.ErrorMessageComponent;

/**
 * 입력을 위한 UI를 출력하고, 입력을 받아오는 역할을 합니다.
 * <p>
 * 출력은 Writer에게,
 * <p>
 * 입력은 Reader에게,
 * <p>
 * 변환은 Dto에게 위임합니다.
 * <p>
 * `InputView`에 의해 최종적으로 반환되는 값은 입력 Dto로 변환되도록 만들었습니다.
 */
public final class InputView {
    private final Writer writer;

    public InputView(final Writer writer) {
        this.writer = writer;
    }

    /**
     * 입력1. 로또 구매 금액을 입력 받아서 BuyLottosDto로 변환 및 반환
     * <p>
     * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
     * <p>
     * retryUntilSuccess는 이름 그대로 콜백 함수에서 예외가 발생하지 않을 때까지 재호출합니다.
     */
    public BuyLottosDto inputBuyLottosDto() {
        return retryUntilSuccess(() -> {
            new InputMoneyComponent().renderTo(writer);
            return BuyLottosDto.from(readLine());
        });
    }


    /**
     * 로또 추첨을 위한 당첨 번호 및 보너스 번호를 입력 받아서 Dto로 변환합니다.
     */
    public DrawLottosDto inputDrawLottosDto() {
        final DrawLottosDtoBuilder builder = DrawLottosDtoBuilder.builder();

        retryUntilSuccess(() -> inputLottoNumbers(builder));
        retryUntilSuccess(() -> inputBonusNumber(builder));

        return builder.build();
    }

    /**
     * 입력2-1. 당첨 번호로 사용할 보너스 번호를 입력 받음.
     *
     * @apiNote 당첨 번호 입력 시, <h3 color="#bf0f4d">input은 반드시 ,로 구분된, 숫자로 이루어진 문자열이여야 합니다.</h3>
     * <p>
     * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
     * <p>
     */
    private DrawLottosDtoBuilder inputLottoNumbers(final DrawLottosDtoBuilder builder) {
        new InputLottoNumbersComponent().renderTo(writer);
        return builder.lottoNumbers(readLine());
    }


    /**
     * 입력2-2. 당첨 번호로 사용할 보너스 번호를 입력 받음.
     *
     * @apiNote 보너스 번호 입력 시, <h3 color="#bf0f4d">input은 반드시 숫자로 이루어진 문자열이여야 합니다.</h3>
     * <p>
     * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
     * <p>
     */
    private DrawLottosDtoBuilder inputBonusNumber(final DrawLottosDtoBuilder builder) {
        new InputBonusNumberComponent().renderTo(writer);
        return builder.bonusNumber(readLine());
    }

    /**
     * 인자로 받은 함수가 성공할 때까지 재귀적으로 호출합니다.
     * <p>
     * 실패할 경우, 예외 메세지를 출력한 뒤 재호출합니다.
     */
    private <T> T retryUntilSuccess(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (final IllegalArgumentException e) {
            new ErrorMessageComponent(e.getMessage())
                    .renderTo(writer);
            return retryUntilSuccess(supplier);
        }
    }

    /**
     * 우아한 테크코스에서 제공하는 `Console` 객체로 한 줄을 읽어옵니다.
     * <p>
     * 간단하게 trim을 호출하여 좌우 공백을 제거하는 것까지 추가하였습니다.
     */
    private String readLine() {
        return Console.readLine().trim();
    }
}
