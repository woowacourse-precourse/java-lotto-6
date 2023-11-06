package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import lotto.Lotto;
import lotto.Model.User;
import lotto.View.LottoView;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private User user;
    private LottoView view;

    public LottoController(User user, LottoView view) {
        this.user = user;
        this.view = view;
    }

    public List<Integer> MakeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(numbers);
        return numbers;
    }

    public void setLottoNumber(){
        this.user.setUserLotto(MakeLotto());
    }
}
