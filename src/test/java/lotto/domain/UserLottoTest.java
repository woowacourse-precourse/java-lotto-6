package lotto.domain;

import lotto.view.SystemInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserLottoTest {

    @DisplayName("check if UserInput works properly")
    @Test
    void checkUserInnputWorks() {
        String userPickLotto = "1,2,3,4,5";
        List<Integer> userPickNumber = new ArrayList<>();
        String[] userPickLottoSplit = userPickLotto.split(",");
        for (String userpick : userPickLottoSplit) {
            userPickNumber.add(Integer.parseInt(userpick));
        }
        assertThat(userPickNumber).isEqualTo(List.of(1,2,3,4,5));
    }

    @Test
    void checkUserBonus() {
        String userBonus = "5";
        int userBonusNumber = Integer.parseInt(userBonus);
        assertThat(userBonusNumber).isEqualTo(5);
    }

}