package lotto;

import java.util.List;

import lotto.Model.MakeAutoTicket;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        MakeAutoTicket test = new MakeAutoTicket();
        List<Integer> numbers = test.getnumbers();
        System.out.println(numbers);
    }
}
