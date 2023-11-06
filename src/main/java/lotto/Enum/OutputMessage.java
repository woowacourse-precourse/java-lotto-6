package lotto.Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum OutputMessage {
    PRINT_CORRECTS("","","","3개 일치","4개 일치","5개 일치","6개 일치","5개 일치, 보너스 볼 일치");
    private final List<String> matchMessages;
    OutputMessage(String... messages){
        matchMessages = new ArrayList<>();
        Collections.addAll(matchMessages, messages);
    }

    public String getCorrectMessageByIndex(int index){
        if (index < 3 && index > matchMessages.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return matchMessages.get(index);
    }
}