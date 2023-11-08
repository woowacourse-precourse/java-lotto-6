package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Input.InputView;
import lotto.Lotto;
import lotto.Output.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLotto {
    public List<Lotto> userLottos = new ArrayList<>();
    public int lottoCount;
    public UserLotto(int purchaseCount){
        this.lottoCount = purchaseCount;
        this.userLottos = IntStream.range(0, purchaseCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    private Lotto createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        OutputView.printUserLotto(numbers);
        return lotto;
    }

}
