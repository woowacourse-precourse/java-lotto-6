package lotto.unit.resultcheck;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.domain.lottos.GetLottosDto;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetWinningNumberDto;
import lotto.dto.result.GetLottoResultDto;
import lotto.service.resultcheck.LottoResultCheck;
import lotto.service.resultcheck.ResultCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCheckUnitTest {
    private ResultCheck resultCheck;
    
    @BeforeEach
    void init(){
        resultCheck = new LottoResultCheck();
    }

    @DisplayName("로또 결과 확인 로직 정상 실행")
    @Test
    void LottoResultCheckNormalCase(){
        //given
        GetWinningNumberDto getWinningNumberDto = prepareWinningNumbers();

        GetBonusNumberDto getBonusNumberDto = new GetBonusNumberDto(7);

        GetLottosDto getLottosDto = prepareLottos();

        //when
        GetLottoResultDto lottoResult = resultCheck.getLottoResult(
                getWinningNumberDto,
                getBonusNumberDto,
                getLottosDto);

        //then
        assertThat(lottoResult.threeHit()).isEqualTo(1);
        assertThat(lottoResult. fiveHit()).isEqualTo(0);
    }

    private static GetLottosDto prepareLottos() {
        List<Integer> oneLottoNumbers = getIntegers();

        List<Lotto> lottos = getLottos(oneLottoNumbers);

        return new GetLottosDto(new Lottos(lottos));
    }

    private static List<Lotto> getLottos(List<Integer> oneLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(oneLottoNumbers));
        return lottos;
    }

    private static List<Integer> getIntegers() {
        List<Integer> oneLottoNumbers = new ArrayList<>();
        addNumbers(oneLottoNumbers);
        return oneLottoNumbers;
    }

    private static void addNumbers(List<Integer> oneLottoNumbers) {
        oneLottoNumbers.add(3);
        oneLottoNumbers.add(4);
        oneLottoNumbers.add(5);
        oneLottoNumbers.add(8);
        oneLottoNumbers.add(9);
        oneLottoNumbers.add(10);
    }

    private static GetWinningNumberDto prepareWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        addWinningNumbers(winningNumbers);
        return new GetWinningNumberDto(winningNumbers);
    }

    private static void addWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }

}
