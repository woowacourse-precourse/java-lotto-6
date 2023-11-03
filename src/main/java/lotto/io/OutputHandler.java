package lotto.io;


import java.util.List;

public final class OutputHandler {

    private OutputHandler(){

    }

    public static void printLotto(List<Integer> lotto){
        System.out.println(lotto.toString());
    }
}
