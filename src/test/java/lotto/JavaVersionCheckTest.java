package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaVersionCheckTest {

    @Test
    public void testJavaVersionIs17() {

        String javaVersion = System.getProperty("java.version");

        assertThat(javaVersion).startsWith("17.");
    }
}
