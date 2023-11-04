package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.boxed.LottoNumber;
import lotto.domain.lotto.validator.LottoValidator;

/**
 * 사용자가 입력한 금액으로 구매한 로또 용지를 나타내는 클래스입니다. 6자리의 로또 번호를 가지고 있습니다.
 */
public final class Lotto implements LottoTicket {


    /**
     * `Lotto` 객체의 유일한 필드이자 6자리의 로또 번호를 나타냅니다.
     */
    private final List<LottoNumber> numbers;

    /**
     * @apiNote Lotto 생성 시, <h3 color="#bf0f4d">numbers의 요소는 반드시 1~45 범위에 속하는 6개의 숫자여야 합니다.</h3>
     */
    public Lotto(final List<Integer> numbers) {
        LottoValidator.validateLottoLength(numbers);
        LottoValidator.validateDuplication(numbers);
        this.numbers = intoLottoNumbers(numbers);
    }

    /**
     * 편의를 위해 Lotto 생성 시, 로또 번호를 List<Integer> 타입으로 받습니다. 이 메소드 내에서 List<Integer>가 List<LottoNumber>로 변환되며, LottoNumber에
     * 대한 검증은 각 자리가 LottoNumber로 변환되는 과정에서 자동으로 이루어집니다.
     * <p>
     * 로또 용지 자체에 오름차순으로 로또 번호가 기재되어 있기 때문에, 로또 용지가 생성될 때부터 오름차순이어야 유효한 데이터라고 생각이 됩니다.
     * <p>
     * 그래서 생성할 때, 여기서 오름차순 정렬을 해줍니다.
     */
    private static List<LottoNumber> intoLottoNumbers(final List<Integer> numbers) {
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
        final List<Integer> unwrappedNumbers = numbers.stream().map(LottoNumber::getValue).toList();
        return new Lotto(unwrappedNumbers);
    }

    /**
     * mapper를 위해 getter open
     */
    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
