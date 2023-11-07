package lotto.View;

import lotto.DTO.SystemMessageDTO;

public class CallSystemMessage {
    public void printMessage(SystemMessageDTO message){
        System.out.println(message.getSystemMessage());
    }
}
