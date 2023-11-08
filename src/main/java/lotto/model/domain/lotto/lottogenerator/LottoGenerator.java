package lotto.model.domain.lotto.lottogenerator;

import lotto.model.domain.lotto.Lotto;

/**
 * {@link Lotto}의 자식 클래스를 생성하기 위한 추상 클래스 입니다.
 * <p>Lotto 타입 클래스들을 생성하려면 해당 클래스를 상속하여 generate()를 override 하세요.</p>
 *
 * @param <L> - 해당 Generator가 생성할 로또 타입
 */
public abstract class LottoGenerator<L extends Lotto> {
    abstract public L generate();
}
