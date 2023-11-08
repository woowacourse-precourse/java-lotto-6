package lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserlottoNumsTest {
    @DisplayName("랜덤으로 생성한 로또가 6개인지 확인하는 테스트")
    @Test
    void testGetlottoNumSize(){
        UserlottoNums userlottoNums = new UserlottoNums(1);
        List<Integer> lottoNumbers = userlottoNums.getlottoNum(0);
        assertThat(lottoNumbers).hasSize(6);
    }

    @DisplayName("랜덤으로 생성한 로또에서 중복 요소 확인하는 테스트")
    @Test
    void testGetlottoNumDuplicateElements(){
        UserlottoNums userlottoNums = new UserlottoNums(1);
        List<Integer> lottoNumbers = userlottoNums.getlottoNum(0);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @DisplayName("랜덤으로 생성한 로또에서 번호 범위를 확인하는 테스트")
    @Test
    void testGetlottoNumRange(){
        UserlottoNums userlottoNums = new UserlottoNums(1);
        List<Integer> lottoNumbers = userlottoNums.getlottoNum(0);
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
    }
    @DisplayName("랜덤으로 생성한 로또들을 담은 리스트에 범위를 벗어날 경우 예외 확인 테스트")
    @Test
    void testGetlottoNumIndexOut() {
        UserlottoNums userlottoNums = new UserlottoNums(1);
        assertThatThrownBy(() -> userlottoNums.getlottoNum(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
