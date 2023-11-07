package lotto.util;

import java.util.List;
import lotto.domain.Lotto;
import lotto.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @DisplayName("당첨 결과 리스트를 생성한다.")
    @Test
    void finalResult() {
        int number = Parser.parsePurchaseAmount("8000");
        List<Lotto> tickets = Generator.publishTickets(number);
        Lotto numbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 44;
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
//        System.out.println("-------------갯수---------------");
//        System.out.println(Computer.drawWinningNumbers(tickets, numbers));
//        System.out.println("-------------보너스---------------");
//        System.out.println(Computer.drawBonusNumber(tickets, bonus));
        System.out.println("-------------결과---------------");
        System.out.println(Computer.computeResult(tickets, numbers, bonus));
        System.out.println("--------------------------------");
    }

//    @DisplayName("당첨된 번호 갯수 리스트를 생성한다.")
//    @Test
//    void winningNumberResult() {
//        int number = Parser.parsePurchaseAmount("8000");
//        List<Lotto> tickets = Generator.publishTickets(number);
//        Lotto numbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
//        for (Lotto lotto : tickets) {
//            System.out.println(lotto.getNumbers());
//        }
//        System.out.println("-------------갯수---------------");
//        System.out.println(Computer.drawWinningNumbers(tickets, numbers));
//        System.out.println("--------------------------------");
//    }
//
//    @DisplayName("당첨된 보너스 번호 유무 리스트를 생성한다.")
//    @Test
//    void bonusNumberResult() {
//        int number = Parser.parsePurchaseAmount("8000");
//        List<Lotto> tickets = Generator.publishTickets(number);
//        int bonus = 44;
//        for (Lotto lotto : tickets) {
//            System.out.println(lotto.getNumbers());
//        }
//        System.out.println("-------------보너스---------------");
//        System.out.println(Computer.drawBonusNumber(tickets, bonus));
//        System.out.println("--------------------------------");
//    }
}
