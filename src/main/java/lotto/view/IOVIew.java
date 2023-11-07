package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IOVIew {
    public void showSingleMessage(final String message){
        System.out.println(message);
    }

    public void showMessages(final List<String> message) {
        message.forEach(System.out::println);
    }

    public String userInput(){
        return Console.readLine();
    }

}
