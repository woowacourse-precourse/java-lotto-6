package lotto.service;


import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;

class LottoServiceTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream input(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}