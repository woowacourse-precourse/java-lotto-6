package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.config.WinningResultConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @DisplayName("model_Winning_result_개수에_따라_값_추가")
    @Test
    public void model_WinningResult_addResult() {
        List<List<Integer>> userLottoNumbers = Arrays.asList(
                Arrays.asList(3, 6, 8, 26, 44, 34),//2
                Arrays.asList(1, 2, 3, 4, 29, 30),//4
                Arrays.asList(1, 2, 3, 4, 5, 8),//5
                Arrays.asList(1, 2, 3, 4, 5, 7),//5, 보너스 볼
                Arrays.asList(1, 2, 3, 4, 5, 6)//6
        );
        int bonusNumber = 7;
        List<Integer> equalCounts = Arrays.asList(2 ,4 ,5, 5, 6);
        List<String> bonus = Arrays.asList("","","","보너스 볼", "");
        List<Result> results = new ArrayList<>();

        for (List<Integer> userNumbers : userLottoNumbers) {
            Result result = new Result(userNumbers,
                    equalCounts.get(userLottoNumbers.indexOf(userNumbers)),
                    bonus.get(userLottoNumbers.indexOf(userNumbers)));
            results.add(result);
        }

        List<Result> filterResults =  results.stream()
                .filter(result -> result.getEqualCount() >= Integer.parseInt(WinningResultConfig.THREE.getResultStatus()))
                .toList();

        WinningResult winningResult = new WinningResult();
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