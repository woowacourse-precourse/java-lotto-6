package view;

import org.junit.jupiter.api.Test;
import validator.LottoCostValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void getInputForLottoCost_예외처리() {
        LottoCostValidator lottoCostValidator = new LottoCostValidator();
        String[] input = {"1000", "7800", "aaaaa", "a s"};
        Object[] acturl = Arrays.stream(input)
                .map(lottoCostValidator::validate)
                .toArray();

        Object[] expected = {true, false, false, false};
        assertArrayEquals(expected,  acturl);
    }
}