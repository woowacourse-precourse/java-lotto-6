package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import component.input.InputBonusNumberComponent;
import component.input.InputLottoNumbersComponent;
import component.input.InputMoneyComponent;
import component.output.ErrorMessageComponent;
import io.output.Writer;
import lotto.controller.dto.input.BuyLottosDto;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.controller.dto.input.builder.DrawLottosDtoBuilder;

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
     * 위 요구 사항을 지키기 위해 실패 시, 재귀 호출로 재입력
     */
    public BuyLottosDto inputBuyLottosDto() {
        new InputMoneyComponent().renderTo(writer);
        try {
            return BuyLottosDto.from(readLine());
        } catch (final IllegalArgumentException e) {
            new ErrorMessageComponent(e.getMessage())
                    .renderTo(writer);
            return inputBuyLottosDto();
        }
    }

    /**
     * 로또 추첨을 위한 당첨 번호 및 보너스 번호를 입력 받아서 Dto로 변환합니다.
     */
    public DrawLottosDto inputDrawLottosDto() {
        final DrawLottosDtoBuilder builder = DrawLottosDtoBuilder.builder();

        inputLottoNumbers(builder);
        inputBonusNumber(builder);

        return builder.build();
    }

    /**
     * 입력2-1. 당첨 번호로 사용할 보너스 번호를 입력 받음.
     *
     * @apiNote 당첨 번호 입력 시, <h3 color="#bf0f4d">input은 반드시 ,로 구분된, 숫자로 이루어진 문자열이여야 합니다.</h3>
     * <p>
     * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
     * <p>
     * 위 요구 사항을 지키기 위해 실패 시, 재귀 호출로 재입력
     */
    private DrawLottosDtoBuilder inputLottoNumbers(final DrawLottosDtoBuilder builder) {
        new InputLottoNumbersComponent().renderTo(writer);

        try {
            builder.lottoNumbers(readLine());
        } catch (final IllegalArgumentException e) {
            new ErrorMessageComponent(e.getMessage())
                    .renderTo(writer);
            return inputLottoNumbers(builder);
        }

        return builder;
    }


    /**
     * 입력2-2. 당첨 번호로 사용할 보너스 번호를 입력 받음.
     *
     * @apiNote 보너스 번호 입력 시, <h3 color="#bf0f4d">input은 반드시 숫자로 이루어진 문자열이여야 합니다.</h3>
     * <p>
     * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
     * <p>
     * 위 요구 사항을 지키기 위해 실패 시, 재귀 호출로 재입력
     */
    private DrawLottosDtoBuilder inputBonusNumber(final DrawLottosDtoBuilder builder) {
        new InputBonusNumberComponent().renderTo(writer);

        try {
            builder.bonusNumber(readLine());
        } catch (final IllegalArgumentException e) {
            new ErrorMessageComponent(e.getMessage())
                    .renderTo(writer);
            return inputBonusNumber(builder);
        }

        return builder;
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
