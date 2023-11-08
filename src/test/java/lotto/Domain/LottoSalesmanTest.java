package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.View.InputLottoUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSalesmanTest {

    @DisplayName("총 지불 금액을 1,000으로 나눴을 때 나머지가 0 이상이라면 예외가 발생한다.")
    @Test
    void lottoCount() {
        int[] moneyValues = {5000, 6005, 7231, 8493, 9000};

        for (int money : moneyValues) {
            if (money % 1000 != 0) {
                System.out.println("[ERROR] 예외처리 money : " + money);
                return;
            }

            int lottoNumber = money / 1000;
            System.out.println("money : " + money + " 몫 : " + lottoNumber);
            assertThat(lottoNumber).isEqualTo(money / 1000);
        }
        System.out.println(" ");
    }

    @DisplayName("1개의 로또번호 발행한다.")
    @Test
    void oneLottoCreate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println("생성된 무작위 6개 로또 번호 : " + numbers);
        System.out.println(" ");
    }

    @DisplayName("여러 장의 로또 구매")
    @Test
    void butLotto() {
        List<List<Integer>> lottos = new ArrayList<>();
        int lottoCount = 3;
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Lotto.createLottoRandomNumber();
            lottos.add(lottoNumbers);
        }
        for(List<Integer> number : lottos){
            System.out.println(number);
        }
        System.out.println(" ");
    }

    @DisplayName("수익률 구하기")
    @Test
    void rankTotal() {
        int totalPrize = 0;
        int prize = 5000;
        int money = 8000;
        int count = 1;

        totalPrize = LottoSalesman.answerCount(count, prize, totalPrize);
        System.out.println("지불 금액 : " + money);
        System.out.println("당첨 금액 : " + 5000);
        System.out.println("수익 금액 : " + totalPrize);
        InputLottoUI.rateOfReturn(totalPrize, money);
        System.out.println(" ");
    }

    @DisplayName("보너스 넘버 체크")
    @Test
    void bonusValidate() {
        int[] bonusValues = {1, 0, 9, 45, 46};
        int[] numTrue = new int[3];
        int[] numFalse = new int[2];
        int i = 0;
        int j = 0;
        for (int bonusNumber : bonusValues) {
            if (bonusNumber > 0 && bonusNumber < 46) { numTrue[i++] = bonusNumber; }
            else { numFalse[j++] = bonusNumber; }
        }
        System.out.println("문제 없는 번호 : " + Arrays.toString(numTrue));
        System.out.println("문제 있는 번호 : " + Arrays.toString(numFalse));

    }
}
