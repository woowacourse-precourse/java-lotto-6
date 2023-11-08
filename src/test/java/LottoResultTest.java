import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("입력된 당첨 번호 개수가 제대로 저장되었는지 확인한다.")
    @Test
    void setLottoResultNumberTest() {
        String[] inputNumbers = {"1", "2", "3", "4", "5", "6"};
        LottoResult lottoResult = new LottoResult(inputNumbers);

        int inputNumberCnt = inputNumbers.length;
        int lottoResultCnt = lottoResult.getLottoResultNumber()
                .getNumbers()
                .size();

        assertThat(inputNumberCnt).isEqualTo(lottoResultCnt);
    }

    @DisplayName("입력된 보너스 번호가 제대로 저장되었는지 확인한다.")
    @Test
    void setBonusResultNumberTest() {
        String inputNumber = "7";
        LottoResult lottoResult = new LottoResult(inputNumber);
        int number = Integer.parseInt(inputNumber);
        int bonusNumber = lottoResult.getBonusNumber();

        assertThat(number).isEqualTo(bonusNumber);
    }

}
