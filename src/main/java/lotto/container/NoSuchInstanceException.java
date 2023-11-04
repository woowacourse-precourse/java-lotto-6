package lotto.container;

public class NoSuchInstanceException extends IllegalStateException {
    public NoSuchInstanceException(String instanceName) {
        super("cannot find instance name of : " + instanceName);
    }
}
