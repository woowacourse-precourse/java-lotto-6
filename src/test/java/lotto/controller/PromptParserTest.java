package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PromptParserTest {
    private PromptParser promptParser;

    @BeforeEach
    void setUp() {
        promptParser = new PromptParser();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "12,12", "23,23", "35,35", "45,45"})
    void integer_성공(String input, int expected) {
        assertThat(promptParser.integer(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,@,,　,..., ,,i"})
    void integer_숫자가아닌입력(String invalidInput) {
        assertThatThrownBy(() -> promptParser.integer(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void integerList_성공() {
        String input = "0,1,2,3,4,5,6,7,8,9,10";
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(promptParser.integerList(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,a,2,3,4,5", ",1,2,3,4,5", "1,2,3,4,5,6,", "...,1,2,3,4"})
    void integerList_숫자가아닌입력(String invalidInput) {
        assertThatThrownBy(() -> promptParser.integerList(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}