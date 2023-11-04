package io.output;

/**
 * FD 1번 STDOUT으로 문자열을 출력합니다.
 */
public final class ConsoleWriter implements Writer {
    @Override
    public void write(final String message) {
        System.out.println(message);
    }
}
