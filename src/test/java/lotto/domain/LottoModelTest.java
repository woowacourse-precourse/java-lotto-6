package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoModelTest {
    private LottoModel lottoModel;

    @BeforeEach
    void setUp() {
        lottoModel = new LottoModel();
    }

    @ParameterizedTest
    @MethodSource("parameterProviderPublishTicket")
    void publishTicket_로또번호_오름차순_발급_확인(List<Integer> lottoNums, String expect) {
        assertThat(lottoModel.publishTicket(lottoNums)).isEqualTo(expect);
    }

    static Stream<Arguments> parameterProviderPublishTicket(){
        return Stream.of(
                arguments(Arrays.asList(5,7,9,3,1),"[1,3,5,7,9]")
        );
    }

    @ParameterizedTest
    @CsvSource({"14.234,14.2","14.286,14.3"})
    void computeRate_소숫점_둘째자리에서_반올림_확인(double test, String expect) {
        assertThat(lottoModel.computeRate(test)).isEqualTo(expect);
    }


}