package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

    public static LottoGenerator lottoGenerator;

    @BeforeAll
    static void init(){
        lottoGenerator = LottoGenerator.getInstance();
    }

    @DisplayName("플레이어 객체를 생성한다.")
    @Test
    void generatePlayerInstance(){
        int money = 5000;
        int issueCount = lottoGenerator.getMaxPurchasableCount(money);
        List<Lotto> lottos = lottoGenerator.issueLottos(issueCount);
        assertThat(new Player(money, lottos))
                .isInstanceOf(Player.class);
    }

    @DisplayName("로또의 당첨 기록을 위한 Map이 초기화 되었는지 확인한다.")
    @Test
    void initResultMapIsValid() {
        int money = 5000;
        int divisionSize= 5;
        int issueCount = lottoGenerator.getMaxPurchasableCount(money);
        List<Lotto> lottos = lottoGenerator.issueLottos(issueCount);
        Player player = new Player(money, lottos);
        try {
            Field resultMap = player.getClass().getDeclaredField("lottoResultsMap");
            resultMap.setAccessible(true);
            Map<Integer, Integer> testMap = (HashMap<Integer, Integer>) resultMap.get(player);
            assertThat(testMap.size())
                    .isEqualTo(divisionSize);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @DisplayName("로또의 결과를 확인한다.")
    @Test
    void checkLottoResultIsValid(){
        List<Integer> winNumber = List.of(1,2,3,4,5,6);
        int money = 6000;
        int bounsNumber = 8;
        List<List<Integer>> numbers = List.of(
            List.of(1,2,3,4,5,6),
            List.of(1,2,3,4,5,8),
            List.of(1,2,3,4,5,9),
            List.of(1,2,3,4,9,10),
            List.of(1,2,3,9,10,11),
            List.of(1,2,9,10,11,12)
        );
        List<Lotto> lottos = numbers.stream()
                .map(number -> new Lotto(number))
                .collect(Collectors.toList());

        Player player = new Player(money, lottos);
        player.checkMyLottoResults(winNumber, bounsNumber);
        //check result string
        String resultStringExpect = "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 1개\n"
                + "5개 일치 (1,500,000원) - 1개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 1개";
        assertThat(player.toStringMyLottoResults())
                .contains(resultStringExpect);
        //check amount
        long totalAmountExpected = 2_000_000_000
                + 30_000_000
                + 1_500_000
                + 50_000
                + 5_000;
        assertThat(player.getTotalAmount())
                .isEqualTo(totalAmountExpected);

        //check ratio of return
        double ratioExpected = totalAmountExpected*100.0 / money;
        assertThat(player.getRatioOfReturn())
                .isEqualTo(ratioExpected);

    }
}
