package lotto;
import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 이력해 주세요.");
        Price price = new Price(Integer.parseInt(Console.readLine()));
        int size = price.countLotto(price);
        System.out.println(size + "개를 구매했습니다.");

        Lotto[] lottos = Lotto.makeLottoNumbers(size);
        Lotto.printLottos(lottos);
    }


}
