package lotto.system.shop.domain;

public interface Viewer {

    void print(String message);

    void print(GuideMessage message);

    void print(MessageFormat message, Object... args);
}
