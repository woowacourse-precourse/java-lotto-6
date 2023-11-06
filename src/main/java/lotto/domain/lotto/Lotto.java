package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.boxed.LottoNumber;
import lotto.domain.lotto.opened.LottoOpened;
import lotto.domain.lotto.validator.LottoValidator;

/**
 * 사용자가 입력한 금액으로 구매한 로또 용지를 나타내는 클래스입니다. 6자리의 로또 번호를 가지고 있습니다.
 */
public class Lotto implements LottoTicket {

    /**
     * `Lotto` 객체의 유일한 필드이자 6자리의 로또 번호를 나타냅니다.
     */
    protected final List<LottoNumber> numbers;

    /**
     * @apiNote Lotto 생성 시, <h3 color="#bf0f4d">numbers의 요소는 반드시 1~45 범위에 속하는 6개의 숫자여야 합니다.</h3>
     * <p>
     * 원래 LottoNumber List로 생성자를 만드려고 했지만,
     * <p>
     * 제네릭이라 오버로딩이 안되고, 기본 테스트 코드를 바꾸지 않고 통과하기 위해 이렇게 만듦
     */
    public Lotto(final List<Integer> numbers) {
        LottoValidator.validateLottoLength(numbers);
        LottoValidator.validateDuplication(numbers);
        this.numbers = toLottoNumbers(numbers);
    }


    /**
     * LottoNumber List로 생성할 경우 사용할 정적 팩토리 메소드
     */
    public static Lotto from(final List<LottoNumber> lottoNumbers) {
        final List<Integer> numbers = lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .toList();

        return new Lotto(numbers);
    }

    /**
     * LottoNumber List -> Integer List 로 변환
     */
    private static List<Integer> toNumbers(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .toList();
    }

    /**
     * 편의를 위해 Lotto 생성 시, 로또 번호를 List<Integer> 타입으로 받습니다. 이 메소드 내에서 List<Integer>가 List<LottoNumber>로 변환되며, LottoNumber에
     * 대한 검증은 각 자리가 LottoNumber로 변환되는 과정에서 자동으로 이루어집니다.
     * <p>
     * 로또 용지 자체에 오름차순으로 로또 번호가 기재되어 있기 때문에, 로또 용지가 생성될 때부터 오름차순이어야 유효한 데이터라고 생각이 됩니다.
     * <p>
     * 알고리즘 등을 학습할 때도 정렬이 된 상태여야만 정상적으로 동작하는 '이진 탐색' 등을 보면,
     * <p>
     * 이진 탐색을 위한 배열은 오름차순 정렬이 된 상태에서만 유효한 상태라고 볼 수 있을 것입니다.
     * <p>
     * DB의 인덱스 트리도 마찬가지로 반드시 주어진 규칙대로 left, right를 가져야 정상 동작한다라고 봤던 기억이 나는데,
     * <p>
     * 다 같은 맥락으로 보여져서 정리 해두었습니다.
     * <p>
     * 그래서 생성할 때, 여기서 오름차순 정렬을 해줍니다.
     */
    private static List<LottoNumber> toLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    /**
     * 로또 번호 포함 여부
     */
    public boolean contains(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    /**
     * 원본 deepcopy
     */
    public Lotto clone() {
        final List<Integer> numbers = this.numbers.stream()
                .map(LottoNumber::getValue)
                .toList();
        return new Lotto(numbers);
    }

    /**
     * @apiNote <h3 color="#bf0f4d">도메인 객체를 Dto로 변환할 때만 호출하며, 도메인 객체의 모든 필드를 가지고 getter만 open 하는 중간 클래스를 만들어줍니다.</h3>
     */
    public LottoOpened toOpened() {
        return new LottoOpened(Lotto.toNumbers(numbers));
    }

}
