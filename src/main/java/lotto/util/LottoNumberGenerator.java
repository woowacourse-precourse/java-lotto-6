package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    //유틸클래스로 만들어야 랜덤 숫자 생성하는 코드를 여러군데에서 호출할수있고 재사용할수있게됨
    //List<Integer>를 반환할지, Lotto를 반환할지??
    //Lotto를 반환하는 경우:
    // 이 방법은 유틸리티 클래스가 Lotto 객체까지 생성하는 책임을 갖습니다.
    // 이 경우 유틸리티 클래스는 Lotto 도메인 클래스에 대한 지식을 가져야 하며,
    // 이는 유틸리티 클래스와 도메인 클래스 간의 결합도를 높이는 결과를 가져올 수 있습니다.
    private LottoNumberGenerator() {
    }

    //유효성 검증은 사용하는 측에서 알아서 하도록 . -> 자신의 책임을 자신이 가지도록 하게 됨
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


}
