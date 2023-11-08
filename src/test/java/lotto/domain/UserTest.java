package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class UserTest {

    private static MockedStatic<Console> consoleMock;
    private static MockedStatic<LottoStore> lottoStoreMocked;

    @AfterAll
    public static void afterAll() {
        consoleMock.close();
    }

    @Test
    void 로또_구매자_수익률_계산_테스트(){
//        stubbing
        given(Console.readLine()).willReturn("5000");

        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;
    }
    @Test
    void 구입한_로또에_대한_결과_테스트(){

    }







}