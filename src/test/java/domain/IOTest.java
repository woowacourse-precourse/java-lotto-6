package domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class IOTest {

    private InputStream sysInBackup;

    @BeforeEach
    protected void backUpSysIn() {
        sysInBackup = System.in;
    }

    @AfterEach
    protected void restoreSysIn() {
        System.setIn(sysInBackup);
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
