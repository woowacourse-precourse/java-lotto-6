package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    private Set<Integer> hashSet = new HashSet<>();
    private TreeSet<Integer> treeSet = new TreeSet<>();
    private Set<Integer> linkedHashSet = new LinkedHashSet<>();

    @BeforeEach
    void beforeEach() {
        hashSet.add(1);
        hashSet.add(31);
        hashSet.add(41);
        hashSet.add(21);
        hashSet.add(8);
        hashSet.add(7);
        hashSet.add(5);
        hashSet.add(45);

        treeSet.add(1);
        treeSet.add(31);
        treeSet.add(41);
        treeSet.add(21);
        treeSet.add(8);
        treeSet.add(7);
        treeSet.add(5);
        treeSet.add(45);

        linkedHashSet.add(1);
        linkedHashSet.add(31);
        linkedHashSet.add(41);
        linkedHashSet.add(21);
        linkedHashSet.add(8);
        linkedHashSet.add(7);
        linkedHashSet.add(5);
        linkedHashSet.add(45);
    }

    @Test
    @DisplayName("hashSet 은 값의 정렬을 보장하지 않는다.")
    void hashSet() {
        for (Integer integer : hashSet) {
            System.out.println(integer);
        }

        Assertions.assertThat(hashSet).contains(1, 5, 7, 8, 21, 31, 41, 45);
        Assertions.assertThat(hashSet).doesNotContainSequence(1, 5, 7, 8, 21, 31, 41, 45);
        Assertions.assertThat(hashSet.size()).isEqualTo(8);
    }

    @Test
    @DisplayName("treeSet 은 값이 정렬 된다. 객체의 경우는 comparable 구현을 해줘야한다.")
    void treeSet() {
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
        Assertions.assertThat(treeSet).contains(1, 5, 7, 8, 21, 31, 41, 45);
        Assertions.assertThat(treeSet).containsExactly(1, 5, 7, 8, 21, 31, 41, 45);
        Assertions.assertThat(treeSet.first()).isEqualTo(1); // 최소 값 (TreeSet 인터페이스 기능)
        Assertions.assertThat(treeSet.last()).isEqualTo(45); // 최대 값 (TreeSet 인터페이스 기능)
    }


    @Test
    @DisplayName("treeSet 은 값이 정렬 된다. 객체의 경우는 comparable 구현을 해줘야한다.")
    void linkedHashSet() {
        for (Integer integer : linkedHashSet) {
            System.out.println(integer);
        }
        Assertions.assertThat(linkedHashSet).contains(1, 5, 7, 8, 21, 31, 41, 45);
        Assertions.assertThat(linkedHashSet).doesNotContainSequence(1, 5, 7, 8, 21, 31, 41, 45);
    }

    @Test
    @DisplayName("HashSet 은 Null 을 허용한다.")
    void testNullInHashSet() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(null);

        Assertions.assertThat(hashSet.size()).isEqualTo(1);
        Assertions.assertThat(hashSet.contains(null)).isTrue();
    }

    @Test
    @DisplayName("TreeSet 은 null 을 허용하지 않는다. 왜냐하면 정렬을 해야하기 때문이다.")
    void testNullInTreeSet() {
        Set<Integer> treeSet = new TreeSet<>();
        Assertions.assertThatThrownBy(() -> treeSet.add(null))
                        .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("LinkedHashSet 은 null 을 허용 한다.")
    void testNullInLinkedHashSet() {
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);

        Assertions.assertThat(linkedHashSet.size()).isEqualTo(1);
        Assertions.assertThat(linkedHashSet.contains(null)).isTrue();
    }

}
