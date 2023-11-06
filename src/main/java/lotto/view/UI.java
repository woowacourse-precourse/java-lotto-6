package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constant.Instructions;

public class UI {

    public static String sendLottoPurchaseRequest() {
        displayMessage(Instructions.MESSAGE_OF_ENTERING_LOTTO_AMOUNT);
        String lottoPurchaseRequest  = Console.readLine();
        return lottoPurchaseRequest;
    }
    public static void displayMessage(final Instructions instructions) {
        System.out.println(instructions.getPrompts());
    }

    public static void displayFormatMessage(final Instructions instructions, Object... args) {
        System.out.printf(instructions.getPrompts(), args);
    }


    public static void displayLottoTicketsHistory(List<Lotto> LottoTickets) {
        //로또구매 내역 객체인 List<Lotto> 형태의 객체를 요구조건 대로 출력해야 된다.
        //구매 갯수인 List의 크기 size()메소드 이용
        //구매 내역은 리스트의 각 요소인 Lotto 객체 내부의 로또 리스트를 읽는다. -> get 메소드 필요하다
        displayFormatMessage(Instructions.MESSAGE_OF_PURCHASE_COUNT, LottoTickets.size());
        for(Lotto lotto : LottoTickets) {
            System.out.println(lotto.getLottoNumbers());
        }

    }
}
