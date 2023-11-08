package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 5, 6, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCompare() {
        Lotto[] testCases = {
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)),
                new Lotto(Arrays.asList(15, 20, 25, 30, 35, 40))
        };
        Lotto[] toCompare = {
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(3, 4, 5, 16, 17, 18)),
                new Lotto(Arrays.asList(16, 21, 26, 31, 36, 41))
        };
        int[] expected = { 6, 3, 0 };

        for (int i = 0; i < testCases.length; i++) {
            assertThat(testCases[i].compare(toCompare[i])).isEqualTo(expected[i]);
        }
    }

    @Test
    void testContains_notContain() {
        Integer[] testCases = {
                12, 13, 14, 15, 16
        };
        Lotto toCheck = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        for (Integer testCase : testCases) {
            assertThat(toCheck.contains(testCase)).isFalse();
        }
    }

    @Test
    void testContains_contains() {
        Integer[] testCases = {
                1, 2, 3, 4, 5, 6
        };
        Lotto toCheck = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        for (Integer testCase : testCases) {
            assertThat(toCheck.contains(testCase)).isTrue();
        }
    }

    @Test
    void testEquals_returnsFalse_ordered() {
        Lotto[][] testCases = {
                {
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
                },
                {
                    new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45)),
                    new Lotto(Arrays.asList(35, 36, 37, 40, 42, 45))
                },
                {
                    new Lotto(Arrays.asList(1, 10, 20, 30, 40, 45)),
                    new Lotto(Arrays.asList(2, 11, 21, 31, 41, 44))
                }
        };

        for (Lotto[] testCase : testCases) {
            assertThat(testCase[0].equals(testCase[1])).isFalse();
        }
    }

    @Test
    void testEquals_returnsFalse_unordered() {
        Lotto[][] testCases = {
                {
                    new Lotto(Arrays.asList(3, 2, 1, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
                },
                {
                    new Lotto(Arrays.asList(40, 43, 42, 41, 44, 45)),
                    new Lotto(Arrays.asList(35, 36, 37, 40, 42, 45))
                },
                {
                    new Lotto(Arrays.asList(45, 40, 30, 20, 10, 1)),
                    new Lotto(Arrays.asList(11, 21, 31, 41, 44, 1))
                }
        };

        for (Lotto[] testCase : testCases) {
            assertThat(testCase[0].equals(testCase[1])).isFalse();
        }
    }

    @Test
    void testEquals_returnsTrue_ordered() {
        Lotto[][] testCases = {
                {
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                },
                {
                    new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45)),
                    new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45))
                },
                {
                    new Lotto(Arrays.asList(1, 10, 20, 30, 40, 45)),
                    new Lotto(Arrays.asList(1, 10, 20, 30, 40, 45))
                }
        };

        for (Lotto[] testCase : testCases) {
            assertThat(testCase[0].equals(testCase[1])).isTrue();
        }
    }

    @Test
    void testEquals_returnsTrue_unordered() {
        Lotto[][] testCases = {
                {
                        new Lotto(Arrays.asList(3, 2, 1, 4, 5, 6)),
                        new Lotto(Arrays.asList(3, 2, 1, 6, 5, 4))
                },
                {
                        new Lotto(Arrays.asList(40, 43, 42, 1, 4, 45)),
                        new Lotto(Arrays.asList(40, 42, 43, 1, 45, 4))
                },
                {
                        new Lotto(Arrays.asList(45, 40, 30, 20, 10, 1)),
                        new Lotto(Arrays.asList(45, 40, 30, 20, 10, 1))
                }
        };

        for (Lotto[] testCase : testCases) {
            assertThat(testCase[0].equals(testCase[1])).isTrue();
        }
    }
}