package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {
    private final List<Lotto> user;

    public UserLotto(int ticketNum) {
        this.user = setUser(ticketNum);
        showUser();
    }

    private List<Lotto> setUser(int ticketNum) {
        System.out.println(String.format("%d개를 구매했습니다.", ticketNum));
        List<Lotto> res = new ArrayList<>();
        for (int index = 0; index < ticketNum; index++) {
            res.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return res;
    }

    public List<Lotto> getLotto() {
        return user;
    }

    public void showUser() {
        for (Lotto l : user) {
            System.out.println(l.getNumbers());
        }
    }
}
