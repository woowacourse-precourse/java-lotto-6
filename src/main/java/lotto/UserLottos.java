package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class UserLottos {
    private List<Lotto> lottos;
    private int size;

    public UserLottos(int amount) {
        this.size = amount/1000;
        this.lottos = new ArrayList<>();
        createLottos(amount);
    }

    // 중복되지 않은 1~45사이 로또 번호 6개 랜덤 생성 및 정렬
    private void createLottos(int amount) {
        for(int i = 0 ; i < size ; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            if (numbers.size() != 6)
                throw new IllegalArgumentException("[ERROR]");

            try {
                Validator.checkDuplicated(numbers);
            } catch (IllegalArgumentException e) {
                throw e;
            }
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
    }

    public int getSize() {
        return this.size;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public String getLottosString() {
        String purhcasedLotto = "";
        for (Lotto lotto : lottos) {
            purhcasedLotto += lotto.getLottoSequence() + "\n";
        }

        return purhcasedLotto;
    }
}
