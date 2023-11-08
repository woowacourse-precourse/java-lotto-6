package lotto.View;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    static OutputView outputView = new OutputView();

    @Test
    void printPhrase() {
        outputView.printPhrase("any string");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains("any string"));
    }

    @Test
    void printMultiplePhrase() {
        outputView.printMultiplePhrase(List.of("1", "2", "3"));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(out.toString().contains("1\n2\n3"));
    }

}