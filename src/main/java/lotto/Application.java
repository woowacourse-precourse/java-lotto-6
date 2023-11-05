package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해주세요.");
        int price = Integer.parseInt(Console.readLine());
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.createLottoList(price);
    }
}
