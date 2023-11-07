package lotto;

import controller.Controller;
import domain.Lotto;
import domain.Rank;
import domain.WinningNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuntionTest {
    private static ByteArrayOutputStream output;

    @BeforeEach
    void setUpStreams() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    Controller controller = new Controller(new Service());

    @DisplayName("asdf.")
    @Test
    void createLottoByOverSize() {
           // List<Integer> winningNum = List.of(1, 2, 3, 4, 5, 6);
//            List<Lotto> lottos = new ArrayList<>();
//            lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
//            lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
//            lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
//            lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
//            lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
//            lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
//            lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
//            lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
//            WinningNumber winningNumber = new WinningNumber(winningNum, 7);
//            LinkedHashMap<Rank, Integer> lottoResult = controller.getLottoResult(lottos, winningNumber);
        LinkedHashMap<Rank, Integer> lottoResult = new LinkedHashMap<Rank, Integer>();
        lottoResult.put(Rank.FIFTH_PLACE,1);
        lottoResult.put(Rank.FOURTH_PLACE,0);
        lottoResult.put(Rank.THIRD_PLACE,0);
        lottoResult.put(Rank.SECOND_PLACE,0);
        lottoResult.put(Rank.FIRST_PLACE,0);
        int money = 8000;
            controller.getRateOfReturn(lottoResult, money);
        assertEquals(output.toString(),"총 수익률은 62.5%입니다.");

    }

}
