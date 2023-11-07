package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import lotto.Lotto;
import lotto.Model.User;
import lotto.View.LottoView;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    final int LOTTOPRICE = 1000;
    private User[] user;
    private LottoView view;

    private int userBuyCount;


    public LottoController(User[] user, LottoView lottoView) {
        this.user = user;
        this.view = lottoView;
    }

    public void start(){
        inputPrice();
        amountLottos();
    }

    public void inputPrice() {
        view.printInputPrice();
        view.setPrice();
    }

    public void amountLottos(){
        setUserBuyCount(view.getPrice());
        view.printNumOfLotto(userBuyCount);
    }

    public List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public void setLottoNumber() {
        for (int i = 0; i < userBuyCount; i++) {
            user[i].setUserLotto(makeLotto());
        }
    }

    public void setUserBuyCount(int price) {
        userBuyCount = price / LOTTOPRICE;
    }
}
