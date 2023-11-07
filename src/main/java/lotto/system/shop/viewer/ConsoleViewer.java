package lotto.system.shop.viewer;

import lotto.system.shop.domain.GuideMessage;
import lotto.system.shop.domain.MessageFormat;
import lotto.system.shop.domain.Viewer;

public class ConsoleViewer implements Viewer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void print(GuideMessage message) {
        System.out.println(message.getMessage());
    }

    @Override
    public void print(MessageFormat message, Object... args) {
        System.out.println(String.format(message.getFormat(), args));
    }
}
