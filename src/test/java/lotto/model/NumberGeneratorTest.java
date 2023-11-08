package lotto.model;

import lotto.constants.LottoConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }
    @DisplayName("1부터 45까지 수 중 6개의 중복되지 않는 숫자를 랜덤하게 생성한다.")
    @RepeatedTest(100)
    @Test
    void getLotteryRandomNumber() {
        int maxValue = LottoConstant.LOTTO_MAX_VALUE.getConstant();
        int minValue = LottoConstant.LOTTO_MIN_VALUE.getConstant();
        int lottoSize = LottoConstant.LOTTO_SIZE.getConstant();

        List<Integer> result = numberGenerator.getLotteryRandomNumber();

        boolean isSuccess = true;

        if (result.size() != lottoSize)
            isSuccess = false;
        if(result.size() != result.stream().distinct().count())
            isSuccess = false;
        if(!result.stream().allMatch(num -> (num >= minValue && num <= maxValue)))
            isSuccess = false;

        assertThat(isSuccess).isTrue();
    }
}