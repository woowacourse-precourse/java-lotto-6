package lotto;

import org.assertj.core.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        /*
        // 로또 당첨 금액 ENUM
        enum LottoAmount {
            FIFTH(5000), FOURTH(50000), THIRD(1500000), SECOND(30000000), FIRST(2000000000);

            private final int value;

            LottoAmount(int value) { this.value = value; }

            public int getValue() { return value; }
        }
         */

        // 입력 1. 로또 구입 금액 1000원 단위로 입력 받기
        int purchaseAmount = Integer.parseInt(readLine());

        // -1000원으로 안 나누어지면 예외처리
        try {
            if(purchaseAmount % 1000 != 0){
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }

        // 게임 1. 구입금액에 따른 로또 구매 개수 구하기
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = purchaseAmount / 1000;

        // 게임 2. 1~45까지의 중복 되지 않는 랜덤 숫자 6개를 구매 개수에 맞게 뽑기
        // 모든 로또 티켓 저장된 리스트
        List<Lotto> lottos = new ArrayList<>();

        while(lottos.size() < lottoCount){
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        /* 게임기능2 확인
        for(Lotto l:lottos){
            List<Integer> intlotto = new ArrayList<Integer>(l.getter());
            for(Integer i:intlotto){
                System.out.println(i);
            }
            System.out.println("---");
        }
        */


        // 입력 2. 쉼표 기준으로 구분해서 당첨 번호 입력 받기










    }
}
