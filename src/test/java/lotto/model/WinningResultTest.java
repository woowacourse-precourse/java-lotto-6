package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;;

import lotto.config.WinningResultConfig;
import org.junit.jupiter.api.*;

class WinningResultTest {
    private static List<List<Integer>> userLottoNumbers;
    private static List<Integer> equalCounts;
    private static List<String> bonus;
    private static List<Result> results = new ArrayList<>();
    private WinningResult winningResult;

    @DisplayName("model_Winning_result_초기화")
    @BeforeAll
    static void model_Winning_result_initialize() {
        userLottoNumbers = Arrays.asList(
                Arrays.asList(3, 6, 8, 26, 44, 34),//2
                Arrays.asList(1, 2, 3, 4, 29, 30),//4
                Arrays.asList(1, 2, 3, 4, 5, 8),//5
                Arrays.asList(1, 2, 3, 4, 5, 7),//5, 보너스 볼
                Arrays.asList(1, 2, 3, 4, 5, 6)//6
        );
        equalCounts = Arrays.asList(2 ,4 ,5, 5, 6);
        bonus = Arrays.asList("","","","보너스 볼", "");

        for (List<Integer> userNumbers : userLottoNumbers) {
            int currentIndex = userLottoNumbers.indexOf(userNumbers);

            Result result = new Result(userNumbers, equalCounts.get(currentIndex), bonus.get(currentIndex));
            results.add(result);
        }
    }

    @DisplayName("model_WinningResult_object_매번_초기화")
    @Test
    @BeforeEach
    void model_WinningResult_object_inialize_everytime() {
        winningResult = new WinningResult();
    }

    @DisplayName("model_WinningResult_object_생성")
    @Test
    @Order(1)
    void model_WinningResult_object_create() {
        List<WinningResultConfig> keyResult = new ArrayList<>();
        for (Map.Entry<WinningResultConfig, List<Result>> results : winningResult.getWinningResults().entrySet()) {
            keyResult.add(results.getKey());
        }
        assertAll(
                () -> assertThat(keyResult)
                        .containsExactly(WinningResultConfig.THREE, WinningResultConfig.FOUR, WinningResultConfig.FIVE, WinningResultConfig.FIVE_AND_BONUS, WinningResultConfig.SIX),
                () -> assertThat(winningResult.getWinningResults().values().stream()
                        .filter(List::isEmpty).count()).isEqualTo(5)
        );
    }

    @DisplayName("model_Winning_result_개수에_따라_값_추가")
    @Test
    @Order(2)
    void model_WinningResult_addResult() {
        List<Result> filterResults =  results.stream()
                .filter(result -> result.getEqualCount() >= Integer.parseInt(WinningResultConfig.THREE.getResultStatus()))
                .toList();

        winningResult.addResult(filterResults);

        assertAll(
                () ->assertThat(winningResult.getWinningResults().get(WinningResultConfig.THREE)).hasSize(0),
                () ->assertThat(winningResult.getWinningResults().get(WinningResultConfig.FOUR)).hasSize(1).contains(filterResults.get(0)),
                () ->assertThat(winningResult.getWinningResults().get(WinningResultConfig.FIVE)).hasSize(1).contains(filterResults.get(1)),
                () ->assertThat(winningResult.getWinningResults().get(WinningResultConfig.FIVE_AND_BONUS)).hasSize(1).contains(filterResults.get(2)),
                () ->assertThat(winningResult.getWinningResults().get(WinningResultConfig.SIX)).hasSize(1).contains(filterResults.get(3))
                );
    }
}