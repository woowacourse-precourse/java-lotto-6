package lotto.domain.lottomachine;

import java.util.List;

public interface LottoMachine {
    /**
     * 로또 번호를 생성한다.
     * @return 생성된 로또 번호
     */
    public List<Integer> generate();
}
