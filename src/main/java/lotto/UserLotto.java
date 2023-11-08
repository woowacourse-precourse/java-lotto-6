package lotto;
/*
    유저 로또 관리 클래스
    setUser: 유저 로또 자동선택 매소드
    getLotto: 유저 로또 반환 매소드
    showUser: 유저 로또 전체 출력 매소드
*/
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {
    private final List<Lotto> user;

    //로또 갯수만큼 유저 로또 자동선택 후 전체 출력
    public UserLotto(int ticketNum) {
        this.user = setUser(ticketNum);
        showUser();
    }

    //setUser: 유저 로또 자동선택 매소드
    private List<Lotto> setUser(int ticketNum) {
        List<Lotto> res = new ArrayList<>();
        for (int index = 0; index < ticketNum; index++) {
            res.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return res;
    }
    
    //getLotto: 유저 로또 반환 매소드
    public List<Lotto> getLotto() {
        return user;
    }

    //showUser: 유저 로또 전체 출력 매소드
    public void showUser() {
        System.out.println(String.format("%d개를 구매했습니다.",user.size()));
        for (Lotto l : user) {
            System.out.println(l.getNumbers());
        }
        System.out.println();
    }
}
