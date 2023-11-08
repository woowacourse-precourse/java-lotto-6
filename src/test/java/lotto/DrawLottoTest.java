package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawLottoTest {
    PurchaseAmount purchaseAmount;
    LottoList lottoList;
    CorrectLotto correctLotto;
    DrawLotto drawLotto;

    @BeforeEach
    void rankSetUp(){
        Rank.FIFTH.setCount(0);
        Rank.FOURTH.setCount(0);
        Rank.THIRD.setCount(0);
        Rank.SECOND.setCount(0);
        Rank.FIRST.setCount(0);
    }

    @DisplayName("당첨된 경우에 해당 당첨 등수의 개수가 잘 세어지는지 확인한다.")
    @Test
    void 당첨_등수_정상_카운트_확인() {
        // given\
        purchaseAmount = new PurchaseAmount();
        purchaseAmount.inputAmount("1000");

        lottoList = new LottoList(purchaseAmount.getAmount());
        correctLotto = new CorrectLotto();
        drawLotto = new DrawLotto(lottoList, correctLotto);

        // when
        drawLotto.countRank(3, false);

        // then
        assertEquals(1, Rank.FIFTH.getCount());
    }

    @DisplayName("당첨 로또와 발행된 로또가 정상적으로 비교되는지 확인한다.")
    @Test
    void 당첨로또_발행로또_정상_비교_확인() {
        // given
        purchaseAmount = new PurchaseAmount();
        purchaseAmount.inputAmount("2000");

        lottoList = new LottoList(purchaseAmount.getAmount());
        lottoList.setLottoList(new ArrayList<>(List.of(new Lotto(List.of(1,2,3,4,5,6)),
                                                        new Lotto(List.of(1,2,3,4,5,7)),
                                                        new Lotto(List.of(1,2,3,4,5,8)),
                                                        new Lotto(List.of(1,2,3,4,8,9)),
                                                        new Lotto(List.of(1,2,3,8,9,10)))));
        correctLotto = new CorrectLotto();
        correctLotto.inputCorrectLotto("1,2,3,4,5,6");
        correctLotto.inputBonus("7");
        drawLotto = new DrawLotto(lottoList, correctLotto);

        // when
        drawLotto.compareNumbers(lottoList.getLottoList().get(0).getNumbers());
        drawLotto.compareNumbers(lottoList.getLottoList().get(1).getNumbers());
        drawLotto.compareNumbers(lottoList.getLottoList().get(2).getNumbers());
        drawLotto.compareNumbers(lottoList.getLottoList().get(3).getNumbers());
        drawLotto.compareNumbers(lottoList.getLottoList().get(4).getNumbers());

        // then
        assertEquals(1, Rank.FIFTH.getCount());
        assertEquals(1, Rank.FOURTH.getCount());
        assertEquals(1, Rank.THIRD.getCount());
        assertEquals(1, Rank.SECOND.getCount());
        assertEquals(1, Rank.FIRST.getCount());
    }

    @DisplayName("당첨 로또와 발행된 로또를 정상적으로 비교하여 잘 추첨되는지 확인한다.")
    @Test
    void 당첨로또_발행로또_정상_추첨_확인() {
        // given
        purchaseAmount = new PurchaseAmount();
        purchaseAmount.inputAmount("5000");

        lottoList = new LottoList(purchaseAmount.getAmount());
        lottoList.setLottoList(new ArrayList<>(List.of(new Lotto(List.of(1,2,3,4,5,6)),
                                                        new Lotto(List.of(1,2,3,4,5,7)),
                                                        new Lotto(List.of(1,2,3,4,5,8)),
                                                        new Lotto(List.of(1,2,3,4,8,9)),
                                                        new Lotto(List.of(1,2,3,8,9,10)))));
        correctLotto = new CorrectLotto();
        correctLotto.inputCorrectLotto("1,2,3,4,5,6");
        correctLotto.inputBonus("7");
        drawLotto = new DrawLotto(lottoList, correctLotto);

        // when
        drawLotto.draw();

        // then
        assertEquals(1, Rank.FIFTH.getCount());
        assertEquals(1, Rank.FOURTH.getCount());
        assertEquals(1, Rank.THIRD.getCount());
        assertEquals(1, Rank.SECOND.getCount());
        assertEquals(1, Rank.FIRST.getCount());
    }
wk
    @DisplayName("수익률을 정상적으로 계산하는지 확인한다.")
    @Test
    void 수익률_정상_계산_확인() {
        // given
        purchaseAmount = new PurchaseAmount();
        purchaseAmount.inputAmount("5000");

        lottoList = new LottoList(purchaseAmount.getAmount());
        lottoList.setLottoList(new ArrayList<>(List.of(new Lotto(List.of(1,2,3,4,5,6)),
                                                        new Lotto(List.of(1,2,3,4,5,7)),
                                                        new Lotto(List.of(1,2,3,4,5,8)),
                                                        new Lotto(List.of(1,2,3,4,8,9)),
                                                        new Lotto(List.of(1,2,3,8,9,10)))));
        correctLotto = new CorrectLotto();
        correctLotto.inputCorrectLotto("1,2,3,4,5,6");
        correctLotto.inputBonus("7");
        drawLotto = new DrawLotto(lottoList, correctLotto);

        // when
        drawLotto.draw();
        drawLotto.calculateProfitPercentage(purchaseAmount.getAmount());

        // then
        assertEquals(40631100.0, drawLotto.getProfitPercentage());
    }
}