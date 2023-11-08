package lotto.view.service;

import java.util.List;

public interface ViewInputService {
    void printMessagePurchaseAmount();

    int inputPurchaseAmount();

    void printMessageWinningNumbers();

    List<Integer> inputWinningNumbers();
}
