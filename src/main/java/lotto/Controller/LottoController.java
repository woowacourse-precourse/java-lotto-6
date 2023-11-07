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

    private User user;
    private LottoView view;
    private List<User> lottos = new ArrayList<User>();
    private int userBuyCount;


    public LottoController( User user, LottoView lottoView) {
        this.user = user;
        this.view = lottoView;
    }

    public void start() {
        inputPrice();
        amountLottos();
        setLottoTickets();
    }

    public void inputPrice() {
        view.printInputPrice();
        view.setPrice();
    }

    public void amountLottos() {
        setUserBuyCount(view.getPrice());
        view.printNumOfLotto(userBuyCount);
    }

    public List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public void setLottoTickets(){
        for(int i =0; i<userBuyCount; i++){
            setLottoNumber();
            printUserLottos();
            lottos.add(user);
        }
    }

    public void setLottoNumber() {
        user.setUserLotto(makeLotto());
    }

    public void setUserBuyCount(int price) {
        userBuyCount = price / LOTTOPRICE;
    }

    public void printUserLottos() {
        view.printLottos(user.getUserLotto());
    }
}
