package lotto.sevice;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Buyer;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.WinningInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest extends NsTest{

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static int NUMBER_START_RANGE = 1;
    private static int NUMBER_END_RANGE = 45;

    private static int MAX_COUNT = 6;

    private final Buyer buyer = new Buyer();
    private final WinningInfo winningInfo = new WinningInfo();
    @DisplayName("구매 금액 입력이 제대로 이루어졌는지 확인")
    @Test
    void savePurchaseAmountTest() {

        String input = "8000";

        int money = Integer.parseInt(input);
        buyer.saveAmount(money);

        System.out.println(buyer.getAmount());
    }

    @DisplayName("구매한 로또 번호 제대로 생성 되는지 확인")
    @Test
    void savePurchaseNumbers() {

        int amount = 3;

        for(int i=0; i<amount; i++) {

            List<Integer> numbers = createNumbers();

            buyer.saveNumbers(numbers);
        }

        List<Lotto> numbersTest = buyer.getLottos();

        for(Lotto lotto : numbersTest){

            for(int i=0; i<6; i++){
               System.out.print(lotto.getNumbers().get(i)+" ");
            }

            System.out.println();
        }
    }

    private List<Integer> createNumbers() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUMBER_START_RANGE, NUMBER_END_RANGE, MAX_COUNT);

        return numbers;
    }

    @DisplayName("당첨 번호, 보너스 번호 입력이 제대로 이루어졌는지 확인")
    @Test
    void saveWinningNumbersTest() {

        String input = "1,2,3,4,5,6";

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).toList();

        winningInfo.saveWinningNumbers(numbers);

        int bonusNumber = 7;

        winningInfo.saveBonusNumber(bonusNumber);

        List<Integer> numbersTest = winningInfo.getWinningNumbers();

        for(int num : numbersTest){

            System.out.print(num+" ");
        }

        System.out.println(winningInfo.getBonusNumber());
    }
    @DisplayName("당첨 내역이 제대로 만들어 지는지 확인")
    @Test
    public void getGameResultTest() {

        winningInfo.saveWinningNumbers(List.of(1,2,3,4,5,6));

        winningInfo.saveBonusNumber(7);

        GameResult gameResult = new GameResult(winningInfo);

        buyer.saveNumbers(List.of(1,2,3,4,5,6));
        buyer.saveNumbers(List.of(1,2,3,4,5,7));
        buyer.saveNumbers(List.of(1,2,3,4,5,8));
        buyer.saveNumbers(List.of(1,2,3,4,9,10));
        buyer.saveNumbers(List.of(1,2,3,10,15,16));

        List<Lotto> lottos = buyer.getLottos();

        gameResult.matchPurchasedLottos(lottos);

        System.out.println(gameResult.getPrize());
    }

    @DisplayName("수익률 계산")
    @Test
    public void getYieldRateTest() {

        winningInfo.saveWinningNumbers(List.of(1,2,3,4,5,6));

        winningInfo.saveBonusNumber(7);

        GameResult gameResult = new GameResult(winningInfo);

        buyer.saveNumbers(List.of(1,2,3,10,15,16));
        buyer.saveNumbers(List.of(9,2,3,10,15,16));
        buyer.saveNumbers(List.of(8,2,3,10,15,16));
        buyer.saveNumbers(List.of(11,2,3,10,15,16));
        buyer.saveNumbers(List.of(17,2,3,10,15,16));
        buyer.saveNumbers(List.of(17,22,3,10,15,16));
        buyer.saveNumbers(List.of(17,23,3,10,15,16));
        buyer.saveNumbers(List.of(17,24,3,10,15,16));

        List<Lotto> lottos = buyer.getLottos();

        gameResult.matchPurchasedLottos(lottos);

        System.out.println(gameResult.getPrize());

        System.out.println(gameResult.getPrizeMoney());
        System.out.println("수익률 : "+(double) gameResult.getPrizeMoney()/8000 * 100+"%");
    }

    @Override
    protected void runMain() {

    }
}
