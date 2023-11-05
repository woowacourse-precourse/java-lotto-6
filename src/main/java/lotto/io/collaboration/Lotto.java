package lotto.io.collaboration;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

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

    // COMMENT : 접근제한자 수정 이야기는 없는데 private으로 바꿔도 되는거겠지?
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto make() {
        // TODO : 외부 라이브러리 의존성 분리
        // TODO : 외부 의존성 사용 테스트 작성
        // TODO : 중복 번호 발생 문제 처리해야 함
        // TODO : 테스트 가능하도록 의존성 주입식으로 변경해야 함
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
