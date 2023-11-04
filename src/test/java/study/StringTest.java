package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitTest() {
        String test = "1,2";
        String[] testSplit = test.split(",");
        String test2 = "1";
        String[] test2Split = test2.split(",");
        assertThat(testSplit).containsExactly("1", "2");
        assertThat(testSplit).contains("2", "1");
        assertThat(test2Split).contains("1");
    }

    @Test
    void substringTest() {
        String test = "(1,2)";

        int startIndex = test.indexOf("(");
        int endIndex = test.indexOf(")");

        String result = test.substring(startIndex + 1, endIndex);

        assertThat(result).contains("1,2");
    }

    @DisplayName("charAt 메서드 IndexOutOfBoundsException 테스트")
    @Test
    void charAtTest() {
        int testIndex = 5;
        assertThatThrownBy(() -> {
            String test = "abc";
            char result = test.charAt(testIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @DisplayName("assertThatExceptionOfType 테스트")
    @Test
    void charAtTest2() {
        int testIndex = 5;
        assertThatThrownBy(() -> {
            String test = "abc";
            if (test.length() <= testIndex)
                throw new IndexOutOfBoundsException("Index: " + testIndex + " Size: " + test.length());
            char result = test.charAt(testIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 5 Size: 3");
    }

    @DisplayName("assertThatThrownBy 테스트")
    @Test
    void charAtTest3() {

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    int testIndex = 5;
                    String test = "abc";
                    if (test.length() <= testIndex)
                        throw new IndexOutOfBoundsException("Index: " + testIndex + " Size: " + test.length());
                    char result = test.charAt(testIndex);
                }).withMessageMatching("Index: \\d+ Size: \\d+");
    }
}