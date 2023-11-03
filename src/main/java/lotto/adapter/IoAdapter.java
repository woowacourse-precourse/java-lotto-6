package lotto.adapter;

import java.util.List;
import lotto.domain.Statistics;

public interface IoAdapter {

    String inputStream();

    void printStatistics(Statistics statistics);

    void printMessage(String message);

    void printLotto(List<Integer> lotto);

    void printNewLine();
}
