package lotto.MyTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaVersionCheckTest {

    @DisplayName("프로그램이 Java17버전인지 확인한다.")
    @Test
    public void testJavaVersionIs17() {

        String javaVersion = System.getProperty("java.version");

        assertThat(javaVersion).startsWith("17.");
    }
}
