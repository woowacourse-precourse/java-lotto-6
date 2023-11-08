package lotto.View;

import lotto.DTO.SystemMessageDTO;

public class CallSystemMessage {
    public void printMessage(SystemMessageDTO message, boolean newLine){
        if(newLine) System.out.println(message.getSystemMessage());
        if(!newLine) System.out.print(message.getSystemMessage());
    }
}
