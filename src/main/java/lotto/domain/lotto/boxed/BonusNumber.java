package lotto.domain.lotto.boxed;

/**
 * 로또 보너스 번호를 박싱한 클래스입니다.
 * <p>
 * LottoNumber를 상속하여 검증이 동일하게 일어나지만,
 * <p>
 * 클래스 구분을 통해 객체 생성 의도를 좀 더 명시적으로 나타낼 수 있습니다.
 */
public final class BonusNumber extends LottoNumber {
    /**
     * @apiNote LottoNumber 생성 시, <h3 color="#bf0f4d">value는 반드시 1 이상 45 이하의 범위에 속해야 합니다.</h3>
     */
    public BonusNumber(final int value) {
        super(value);
    }

}
