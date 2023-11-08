package controller;

import model.Lotto;
import model.Lottos;
import view.Input;
import view.Output;

public class Message {

    public static void start() {
        Input.inputPrice();
    }

    public static void inputPrize() {
        Input.inputPrize();
    }

    public static void inputBonus() {
        Input.inputBonus();
    }

    public static void printLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            lotto.printLotto();
        }
    }

    public static void printOuttro() {
        Output.printResult();
    }

    public static void printCount(int purchase) {
        Output.printCount(purchase);
    }

}
