package lotto;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractMasterDetailListProcessor;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayLotto {

    Money money;

    public void play(){
        getMoney();
    }

    public void getMoney(){
        try{
            money = new Money(readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getMoney();
        }
    }
}
