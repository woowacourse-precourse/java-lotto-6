package lotto.io;


import java.util.List;

public final class OutputHandler {

    private OutputHandler(){

    }

    public static void printLotto(List<Integer> lotto){
        System.out.println(lotto.toString());
    }

    public static void printReceipts(int size){
        System.out.println(size+"개를 구매했습니다.");
    }
}
