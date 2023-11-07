package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public List<Lotto> makeLottoList(int count) {
        List<Lotto> lotto_list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto_list.add(makeToLotto());
        }

        return lotto_list;
    }

    private List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(Range.START.content(), Range.END.content(), Range.COUNT.content());
    } //start(1)에서 end(45)까지의 랜덤하면서 유일한 숫자 count(6)개 발행

    private List<Integer> sortLotto() {
        return makeLotto().stream()
                .sorted()
                .collect(Collectors.toList());
    } //오름차순 정렬

    private Lotto makeToLotto() {
        return new Lotto(sortLotto());
    }
}
