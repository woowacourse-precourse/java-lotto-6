package study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("입력값 학습 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InputTest {

    @Test
    void 큰_숫자_입력을_받을_수_있다() {
        String input = "100000000000000";
//        int number = Integer.parseInt(input);

//        System.out.println(number);
    }
}
