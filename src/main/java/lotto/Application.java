package lotto;

import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

import static lotto.constant.LottoConstant.*;

public class Application {
    private static LottoInputView inputView;
    private static LottoOutputView outputView;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void validateIntegers(List<String> input) {
        if (!LottoUtil.isIntegers(input)) {
            throw new IllegalArgumentException("로또 번호는 정수만 가능합니다.");
        }
    }

    public static void validateBuyingPrice(String input) {
        if (!LottoUtil.isInteger(input)) {
            throw new IllegalArgumentException("구매가격은 정수만 가능합니다");
        }
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("구매가격은 0보다 큰 값만 가능합니다.");
        }
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매가격은 1000의 배수만 가능합니다.");
        }
    }

    public static void validateBonusNumber(String input) {
        if (!LottoUtil.isInteger(input)) {
            throw new IllegalArgumentException("보너스 번호는 정수만 가능합니다.");
        }
        if (!LottoUtil.isInRange(Integer.parseInt(input), LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException("로또 번호는 1~45값만 가능합니다.");
        }
    }
}
