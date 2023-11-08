package lotto;

import lotto.Controller.LottoController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
