package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.User;
import lotto.ui.Computer;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> lottos = new ArrayList<>();

        User user = new User();
        Computer computer = new Computer();
        user.purchaseLotto();

        // 로또 개수 만큼 번호 계산
        for(int i =0; i<user.lottoCount; i++){
            lottos.add(computer.calculateLottoNumber());
        }


    }
}
