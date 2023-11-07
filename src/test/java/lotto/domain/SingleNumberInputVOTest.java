package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberInputVOTest {

    @Test
    void null_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new SingleNumberInputVO(null));
    }

    @Test
    void 빈_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new SingleNumberInputVO(""));
    }

    @Test
    void 공백_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new SingleNumberInputVO("    "));
    }

    @Test
    void 문자열_입력() {
        assertThrows(IllegalArgumentException.class, () ->
                new SingleNumberInputVO("ㅁㄴㅇㄹ"));
    }
}