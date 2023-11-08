package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    void confirmLotto() {
        Winner winner = new Winner();
        ArrayList<Integer>[] YourNumber = new ArrayList[5];
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(3,12,29,34,40,44));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3,12,29,32,30,40));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(3,12,29,32,39,45));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(3,12,29,32,39,41));
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(3,12,29,32,39,42));
        YourNumber[0] = arr1;
        YourNumber[1] = arr2;
        YourNumber[2] = arr3;
        YourNumber[3] = arr4;
        YourNumber[4] = arr5;

        ArrayList<Integer> lotto = new ArrayList<>(Arrays.asList(3,12,29,32,39,42));
        Integer bonus = 41;
        ArrayList<Integer> result = winner.ConfirmLotto(YourNumber,lotto,bonus);
        ArrayList<Integer> resultCmp = new ArrayList<>(Arrays.asList(0,0,0,1,1,1,1,1));

        assertThat(result).isEqualTo(resultCmp);

    }

    @Test
    void checkDuplicate() {
        Winner winner = new Winner();
        ArrayList<Integer> arrA = new ArrayList<>(Arrays.asList(3,12,29,32,39,42));
        ArrayList<Integer> arrB = new ArrayList<>(Arrays.asList(3,12,29,32,39,42));
        Integer result = winner.checkDuplicate(arrA,arrB);
        assertThat(result).isEqualTo(6);
    }

}