package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAmountTest {

    @Test
    public void 유저_입력_금액_생성_테스트() {
        //given
        UserAmount userAmount1 = new UserAmount(4000);
        UserAmount userAmount2 = new UserAmount(54000);
        UserAmount userAmount3 = new UserAmount(37000);

        //when
        int numberOfLotto1 = userAmount1.getNumberOfLotto();
        int numberOfLotto2 = userAmount2.getNumberOfLotto();
        int numberOfLotto3 = userAmount3.getNumberOfLotto();

        //then
        Assertions.assertThat(numberOfLotto1).isEqualTo(4);
        Assertions.assertThat(numberOfLotto2).isEqualTo(54);
        Assertions.assertThat(numberOfLotto3).isEqualTo(37);
    }
}
