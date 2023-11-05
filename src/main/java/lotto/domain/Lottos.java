package lotto.domain;

import static lotto.etc.Validate.validateNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(String timeStr) {
        lottos = new ArrayList<>();
        int timeInt = validateNumber(timeStr)/1000;
        validateThousand(timeStr);
        for (int i = 0; i < timeInt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
    }

    private void validateThousand(String time) {
        if (time.length() <= 3) {
            throw new IllegalArgumentException("[ERROR] 입력된 숫자가 1,000보다 작습니다.");
        }

        String lastThreeChars = time.substring(time.length() - 3);
        if (!lastThreeChars.equals("000")) {
            throw new IllegalArgumentException("[ERROR] 들어온 숫자가 천의 자리로 나누어 떨어지지 않습니다.");
        }
    }

    public int getLottoCount(){
        return lottos.size();
    }
    public List<Lotto> getLottos(){
        return lottos;
    }
}
