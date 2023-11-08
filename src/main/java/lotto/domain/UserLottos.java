package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.Validator;

public class UserLottos {
    private List<Lotto> lottos;
    private int size;

    public UserLottos(int amount) {
        this.size = amount / 1000;
        this.lottos = new ArrayList<>();
        createLottos(amount);
    }

    // 중복되지 않은 1~45사이 로또 번호 6개 랜덤 생성 및 정렬
    private void createLottos(int amount) {
        for (int i = 0; i < size; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Validator.checkDuplicated(numbers);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
    }

    // 로또 구매 수량 반환
    public int getSize() {
        return this.size;
    }

    // 사용자가 구매한 로또 리스트 반환
    public List<Lotto> getLottos() {
        return lottos;
    }

    // 사용자가 구매한 로또들의 번호 문자열 반환
    public String getLottosString() {
        String purhcasedLotto = "";
        for (Lotto lotto : lottos) {
            purhcasedLotto += lotto.getLottoString() + "\n";
        }

        return purhcasedLotto;
    }
}
