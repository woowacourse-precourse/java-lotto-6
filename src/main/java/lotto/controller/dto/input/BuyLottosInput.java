package lotto.controller.dto.input;

import lotto.controller.exception.InvalidLottoPriceUnitException;
import lotto.domain.lotto.LottoStore;
import lotto.controller.parser.StrictInputParser;

/**
 * 첫 번째 입력인 로또를 구매하기 위해 사용자가 입력한 '구입 금액'을 저장하는 Input Dto
 */
public final class BuyLottosInput {

    /**
     * 현실에서는 구매 금액이 인당 100,000원으로 제한되어 있어서 long이 적절하지 않을 수 있지만, 연습용 미션이고 추후 큰 단위를 테스트 해볼 수도 있기 때문에 일단 long을 넣어둠
     * <p>
     * `int`의 범위는 -2,147,483,648 ~ 2,147,483,647으로 생각보다 매우 작음.
     * <p>
     * `long`의 범위는 이보다 훨씬 큰 -9,223,372,036,854,775,808 ~ 9,223,732,036,854,775,807이기 때문에
     * <p>
     * 미국 연간 GDP의 400배 가까이 됨.
     * <p>
     * 로또를 전 세계 모든 사람이 사도 절대 도달 불가능하므로 안전.
     */
    private final long amount;

    private BuyLottosInput(final String input) {
        final long amount = StrictInputParser.mustParseToLong(input);
        validateLottoPrice(amount);
        this.amount = amount;
    }

    /**
     * 사용자의 입력을 Dto로 변환.
     * <p>
     * Dto 스스로 입력에 대한 검증 및 변환을 처리하도록 함
     */
    public static BuyLottosInput from(final String input) {
        return new BuyLottosInput(input);
    }

    /**
     * Wallet 내에 들어갈 잔액은 로또 가격으로 나누어 떨어져야 합니다.
     */
    public static void validateLottoPrice(final long amount) {
        long isDivisibleByLottoPrice = amount % LottoStore.LOTTO_PRICE.toLong();
        if (isDivisibleByLottoPrice != 0) {
            throw new InvalidLottoPriceUnitException();
        }
    }

    /**
     * Getter
     */
    public long getAmount() {
        return amount;
    }

}
