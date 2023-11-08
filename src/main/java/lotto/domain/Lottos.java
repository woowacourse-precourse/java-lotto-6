package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * Lotto들을 저장하고 관리하는 domain
 */
public class Lottos {
    private final List<Lotto> lottos = new ArrayList<Lotto>();

    /**
     * 입력받은 양만큼 lotto를 생성하여 저장
     *
     * @param amount 생성할 lotto양
     */
    public void generateLotto(int amount) {
        for (int generateCount = 0; generateCount < amount; generateCount++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); //1~45 숫자 6개를 가진 List생성
            lottos.add(new Lotto(numbers));
        }
    }

    /**
     * 각 Lotto별로 출력하는 메서드
     */
    public void printLottos() {
        lottos.stream().forEach(lotto -> {
            lotto.printLotto();
        });
    }
}
