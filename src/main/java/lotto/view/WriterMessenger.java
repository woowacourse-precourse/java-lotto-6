package lotto.view;

import lotto.utils.Writer;

public class WriterMessenger implements Messenger {
    @Override
    public void print(String string) {
        Writer.print(string);
    }
}
