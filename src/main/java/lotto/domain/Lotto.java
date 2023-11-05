package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 번호 리스트를 담고 있는 클래스
 */
public class Lotto {
    private final List<LottoNumber> numbers;

    // 로또 번호 발행 시 사용할 생성자
    public Lotto() {
        this.numbers = issueLotto();
        Collections.sort(this.numbers);
    }

    // 사용자가 당첨번호 입력 시 사용할 생성자
    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);

        this.numbers = changeIntToLottoNumber(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoValue.WINNING_NUMBER_CNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_CNT.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUM.getMessage());
        }
    }

    // Integer 리스트를 LottoNumber 리스트로 변환
    private List<LottoNumber> changeIntToLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(e -> new LottoNumber(e)).collect(Collectors.toList());
    }

    // 로또 숫자 리스트 랜덤하게 선택 후 List<LottoNumber> 형태로 반환
    private List<LottoNumber> issueLotto() {
        return changeIntToLottoNumber(pickRankNum());
    }

    private List<Integer> pickRankNum() {
        return Randoms.pickUniqueNumbersInRange(LottoValue.MIN_VALUE.getValue(),
                LottoValue.MAX_VALUE.getValue(), LottoValue.WINNING_NUMBER_CNT.getValue());
    }
}
