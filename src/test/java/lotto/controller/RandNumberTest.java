package lotto.controller;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class RandNumberTest {

    @Test
    @DisplayName("중복되지 않는 로또 번호 6개 생성")
    public void testRandomNumber() {
        RandNumber randNumber = new RandNumber();
        List<Integer> lottoNumbers = randNumber.makeLottoNumber();

        // 로또 번호가 6개인가?
        assertThat(lottoNumbers).hasSize(6);

        // 1과 45 사이인가?
        assertThat(lottoNumbers).allSatisfy(number -> assertThat(number).isBetween(1,45));

        // 중복되지 않아야한다.
        assertThat(lottoNumbers).doesNotHaveDuplicates();

    }

}
