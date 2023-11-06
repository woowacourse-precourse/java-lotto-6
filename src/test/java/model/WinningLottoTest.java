package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {





  @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인한다.")
  @Test
  void sortNumbers() {
    List<Integer> numbers = new ArrayList<>(List.of(10, 5, 40, 31, 21, 9));
    WinningLotto winningLotto = new WinningLotto(numbers, 7);
    Collections.sort(numbers);
    assertEquals(numbers, winningLotto.getNumbers());
  }
}