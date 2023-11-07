package lotto.domain.view;

import lotto.enums.UserInterfaceMessage;

public class OutputView {
    public void printPublishCount(int size) {
        System.out.printf(UserInterfaceMessage.COUNT_BOUGHT.getValue() + "\n", size);
    }
}
