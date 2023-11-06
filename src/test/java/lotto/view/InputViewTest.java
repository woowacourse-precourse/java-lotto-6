package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.MyTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("입력 뷰 테스트")
class InputViewTest extends MyTest {

    @Test
    void 구입_금액을_입력_받고_몇개를_구매했는지_읽어라 () {
        //given
        String arg = "10000";

        //when
        Integer actual = input(arg, InputView::readPurchaseAmountAndCount);

        //then
        assertThat(output()).isEqualTo("구입금액을 입력해 주세요.\n\n"
                + "10개를 구매했습니다.\n");
        assertThat(actual).isEqualTo(10);
    }

    @Test
    void 당첨_번호를_입력_받아라 () {
        //given
        String arg = "1,10,12,24,32,44";
        List<Integer> expected = List.of(1, 10, 12, 24, 32, 44);

        //when
        List<Integer> actual = input(arg, InputView::readAnswerNumbers);

        //then
        assertThat(output()).isEqualTo("\n당첨 번호를 입력해 주세요.\n");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 보너스_번호를_입력_받아라 () {
        //given
        String arg = "7";

        //when
        Integer actual = input(arg, InputView::readBonusNumber);

        //then
        assertThat(output()).isEqualTo("\n보너스 번호를 입력해 주세요.\n");
        assertThat(actual).isEqualTo(7);
    }
}
