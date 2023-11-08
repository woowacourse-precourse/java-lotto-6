package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.boxed.LottoNumber;

public interface LottoTicket {
    /**
     * 각 로또 용지가 갖는 로또 번호의 개수입니다. 요구 사항에 따라 6자리 고정 크기로 설정 되었습니다.
     */
    int NUMBERS_COUNT = 6;

    /**
     * 편의를 위해 Lotto 생성 시, 로또 번호를 List<Integer> 타입으로 받습니다. 이 메소드 내에서 List<Integer>가 List<LottoNumber>로 변환되며, LottoNumber에
     * 대한 검증은 각 자리가 LottoNumber로 변환되는 과정에서 자동으로 이루어집니다.
     */
    static List<LottoNumber> intoLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }
}
