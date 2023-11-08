package lotto.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.view.output.DisplayAnnounce;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisplayViewTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }


    @DisplayName("입력받은 리스트를 올바른 형식으로 출력해야 한다.")
    @Test
    void displayBoughtTicketsTest() {
        // 변수 설정
        DisplayAnnounce announce = new DisplayAnnounce();
        String ticket1 = "[1, 2, 3, 4, 5, 6]";
        String ticket2 = "[40, 41, 42, 43, 44, 45]";
        List<String> list = List.of(ticket1, ticket2);

        // 출력
        announce.displayBoughtTickets(list);
        // 출력 결과 확인
        assertTrue(output().contains(ticket1));
        assertTrue(output().contains(ticket2));
    }

}
