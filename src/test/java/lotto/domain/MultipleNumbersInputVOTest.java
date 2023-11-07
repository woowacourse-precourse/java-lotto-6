package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MultipleNumbersInputVOTest {

    @Test
    void null_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new MultipleNumbersInputVO(null));
    }

    @Test
    void 빈_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new MultipleNumbersInputVO(""));
    }

    @Test
    void 공백_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new MultipleNumbersInputVO("    "));
    }

    @Test
    void 문자열_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new MultipleNumbersInputVO("ㅁㄴㅇㄹ"));
    }

    @Test
    void 컴마_한번에_여러개_입력은_정상파싱() {
        MultipleNumbersInputVO input = new MultipleNumbersInputVO("1,,2,3,4,5");
        assertThat(input.getParsingNumbers()).containsExactly(1,2,3,4,5);
    }

    @Test
    void 컴마_다음에_공백_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new MultipleNumbersInputVO("1, ,2,3"));
    }

    @Test
    void 컴마_다음에_문자열_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new MultipleNumbersInputVO("1,에이,2,3"));
    }

    @Test
    void 컴마_다음에_공백숫자_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new MultipleNumbersInputVO("1, 6,2,3"));
    }
}