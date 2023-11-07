package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.view.LottoView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class LottoControllerTest {


    @Test
    @DisplayName("로또 생성 테스트")
    void testProcessCreateLotto() {
        int purchaseAmount = 5000;
        List<Lotto> lottoList = Lotto.createLottoList(purchaseAmount);
        assertNotNull(lottoList);
        assertEquals(5, lottoList.size());
    }

    @Test
    @DisplayName("당첨번호 입력 테스트")
    void testProcessInputWinningNumber() {
        String input = "1,2,3,4,5,6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        LottoController.processInputWinningNumber();

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), LottoController.totalWinningNumbers);
    }




}