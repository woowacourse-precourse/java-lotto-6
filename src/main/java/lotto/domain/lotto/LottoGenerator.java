package lotto.domain.lotto;

/**
 * 임의의 로또 번호 혹은 고정된 로또 번호를 생성할 수 있는 2가지 구현체가 존재합니다.
 * <p>
 * 임의의 번호는 런타임에, 고정된 번호는 테스트 시에 사용됩니다.
 */
public interface LottoGenerator {
    Lotto generate();
}
