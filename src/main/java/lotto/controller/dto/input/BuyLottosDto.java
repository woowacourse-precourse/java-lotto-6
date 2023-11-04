package lotto.controller.dto.input;

import lotto.controller.exception.NumericInputValidationException;

/**
 * 첫 번째 입력인 로또를 구매하기 위해 사용자가 입력한 '구입 금액'을 저장하는 Input Dto
 */
public final class BuyLottosDto {

    /**
     * 현실에서는 구매 금액이 인당 100,000원으로 제한되어 있어서 long이 적절하지 않을 수 있지만, 연습용 미션이고 추후 큰 단위를 테스트 해볼 수도 있기 때문에 일단 long을 넣어둠
     */
    private final long amount;

    private BuyLottosDto(final String input) {
        validateInput(input);
        this.amount = Long.parseLong(input);
    }

    /**
     * 사용자의 입력을 Dto로 변환.
     * <p>
     * Dto 스스로 입력에 대한 검증 및 변환을 처리하도록 함
     */
    public static BuyLottosDto from(final String input) {
        return new BuyLottosDto(input);
    }

    /**
     * 숫자로 이루어진 입력이 아니라면 예외 발생.
     */
    private static void validateInput(final String input) {
        final char[] chars = input.toCharArray();

        for (final char ch : chars) {
            if (!Character.isDigit(ch)) {
                throw new NumericInputValidationException();
            }
        }
    }

    /**
     * Getter
     */
    public long getAmount() {
        return amount;
    }


}
