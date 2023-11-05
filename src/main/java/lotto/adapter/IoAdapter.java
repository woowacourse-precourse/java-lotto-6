package lotto.adapter;

import java.util.List;

public interface IoAdapter {

    String inputStream();

    void printMessage(String message);

    void printLotto(List<Integer> lotto);

    void printNewLine();
}
