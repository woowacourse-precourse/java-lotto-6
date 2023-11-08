package lotto;

import lotto.controller.LottoSystem;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoSystem lottoSystem = new LottoSystem();
        try{
            lottoSystem.runSystem();
        }catch (IllegalArgumentException e){
            System.out.println("실행 종료");
        }
    }
}
