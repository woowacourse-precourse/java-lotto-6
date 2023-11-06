package lotto.collaboration.lottos;

import java.util.List;
import java.util.stream.Stream;
import lotto.game.io.Randoms;

public class Lotto {

    /*
    COMMENT :
        주어진 Lotto 클래스의 numbers 필드를 변경할 수 없다.
        새로운 필드 추가도 불가능하다.
        패키지 변경은 가능하다.
        추가 기능 구현은 가능하다.
        이 주석은 제출 전 반드시 제거한다.
     */
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        occurExceptionIfOutOfRange(numbers);
        occurExceptionIfNotSix(numbers);
        occurExceptionIfDuplicated(numbers);
    }

    private void occurExceptionIfOutOfRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || 45 < number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자 중에서 선택할 수 있습니다");
        }
    }

    private void occurExceptionIfNotSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void occurExceptionIfDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public static Lotto make(Randoms randoms) {
        // TODO : 외부 의존성 사용 테스트 작성
        // TODO : 중복 번호 발생 문제 처리해야 함 (현재 예외 발생하고 있으나, 알아서 재생성해주도록 하는 편이 좋겠다고 생각함. 사용자가 조작하지 않는 부분의 부작용까지 사용자에게 알리면 필요치않게 혼동이 커짐)
        return new Lotto(randoms.getSixNumbers());
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
