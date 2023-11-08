package lotto.domain;

import lotto.constants.ResultConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class UserTest {
    @BeforeEach
    void setUp() {
        User user = new User(5000);
    }


    @DisplayName("당첨 번호의 개수에 따라 Map에 정보가 저장되는지 확인하는 테스트")
    @Test
    void saveResultTest() {
        User user = new User(8000);
        for (ResultConfig rc: ResultConfig.values()) {

        }
        assertThat(user.totalResult).extracting("3").isEqualTo(4);
    }
}