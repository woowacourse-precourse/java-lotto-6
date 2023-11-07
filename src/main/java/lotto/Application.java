package lotto;

import static lotto.controller.LottoController.*;

public class Application {

    public static void main(String[] args) {
        try{
            play();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
