package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validators;

import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    public int receiveMoney(){
        String inputMoney = Console.readLine();
        while(!Validators.validate(inputMoney)) {inputMoney = Console.readLine();}
        return Integer.parseInt(inputMoney);
    }
    public void printTickets(int numberOfTickets) {
        // 임시 자료 구조: 오브젝트 리스트로 관리
        ArrayList<Object> customerTickets = new ArrayList<>();

        for(int i=0; i<numberOfTickets; i++) {
            customerTickets.add(new Ticket());
            System.out.println(customerTickets.get(i));
        }
    }
}
