package lotto.domain;

import lotto.utils.LottoNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {
    int purchaseAmount;
    int column;
    int row;

    LottoGame lottoGame;
    List<Lotto> lottoTickets;

    @BeforeEach
    void setUp() {
        purchaseAmount = 8;

        lottoGame = new LottoGame(purchaseAmount);
        lottoTickets = lottoGame.getLottoTickets();

        //세로
        column = lottoTickets.size();

        //가로
        row = lottoTickets.get(0).getLottoNumbers().size();
    }


    @DisplayName("로또 구매 개수만큼 랜덤 로또 번호 생성되는지 테스트")
    @Test
    void generateLottoTickets() {

        assertAll(
                ()-> assertEquals(column, purchaseAmount),
                () -> assertEquals(row, 6)
        );

    }

    @DisplayName("랜덤 생성한 로또 티켓의 클래스 유형 확인 테스트와 개수가 맞는지 확인 테스트")
    @Test
    void getLottoTickets() {
        assertAll(
                ()-> assertEquals(ArrayList.class, lottoTickets.getClass()),
                () -> assertEquals(Integer.class, lottoTickets.get(1).getLottoNumbers().get(1).getClass()),
                () -> assertEquals(lottoTickets.get(0).getLottoNumbers().size(), row),
                () -> assertEquals(lottoTickets.size(), column)
        );
    }


    @DisplayName("랜덤 생성한 로또 티켓들 중 하나를 가져와서 확인하는 테스트")
    @Test
    void getLottoTicket(){

        ArrayList<Object> originalList = new ArrayList<>();


        List<Object> subList = originalList.subList(0, originalList.size());

        List<Integer> lottoTicket = lottoGame.getLottoTicket(0);


        assertAll(
                () -> assertEquals(lottoTicket.getClass(), subList.getClass()),
                () -> assertEquals(lottoTicket.size(), 6)
        );
    }
}