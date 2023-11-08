package lotto.domain;

import static lotto.global.constants.NumberType.LOTTO_SIZE;
import static lotto.global.constants.NumberType.MAX_LOTTO_NUMBER;
import static lotto.global.constants.NumberType.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(final int count) {
        lottos = new ArrayList<>();
        generateRandomNumber(count);
    }

    /**
     * 여러 개의 로또를 생성하는 메서드
     *
     * @param count 생성할 로또 갯수
     * @return 여러 개의 로또의 정보가 저장된 객체
     */
    public static Lottos from(final int count) {
        return new Lottos(count);
    }

    /**
     * 무작위로 로또 번호를 생성하는 메서드
     *
     * @param count 생성할 로또 갯수
     */
    private void generateRandomNumber(final int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    MIN_LOTTO_NUMBER.getValue(),
                    MAX_LOTTO_NUMBER.getValue(),
                    LOTTO_SIZE.getValue());
            lottos.add(Lotto.from(parse(numbers)));
        }
    }

    /**
     * 정수 리스트의 입력을 래퍼 클래스의 리스트로 파싱하는 메서드
     *
     * @param numbers 정수 리스트의 입력
     * @return 래퍼 클래스의 리스트
     */
    public static List<Number> parse(final List<Integer> numbers) {
        return numbers.stream()
                .map(Number::valueOf)
                .toList();
    }

    /**
     * 로또의 갯수를 반한하는 메서드
     *
     * @return 로또의 갯수
     */
    public int getSize() {
        return lottos.size();
    }

    /**
     * 로또들의 정보를 반환하는 메서드
     *
     * @return 로또 객체의 리스트
     */
    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
