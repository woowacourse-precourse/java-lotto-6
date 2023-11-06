package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<Integer>();
        System.out.println("구입금액을 입력해 주세요.");
        int buyLotto = Integer.parseInt(Console.readLine());
        // 1000원 단위 입력 확인(method로 추후 분리 예정)
        if (buyLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] ");
        }

        // 구매 확인 및 리스트
        int lottoNum = buyLotto / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");

        // 당첨번호 입력


        // 당첨 통계


        Lotto lt = new Lotto(numbers);


    }
}
