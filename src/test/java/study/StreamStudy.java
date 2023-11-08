package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudy {
    @Test
    void 생성하기_배열() {
        String[] strings = new String[]{"apple", "banana", "kiwi"};
        assertThat(Arrays.stream(strings)).isInstanceOf(Stream.class);
    }

    @Test
    void 생성하기_콜렉션() {
        List<String> list = Arrays.asList("apple", "banana", "kiwi");
        assertThat(list.stream()).isInstanceOf(Stream.class);
    }

    @Test
    void 생성하기_스트림빌터() {
        Stream<String> builder = Stream.<String>builder()
                .add("apple")
                .add("banana")
                .add("kiwi")
                .build();
        assertThat(builder.count()).isEqualTo(3);
    }

    @Test
    void 가공하기_mapping() {
        List<String> list = Arrays.asList("apple", "banana", "kiwi");
        list = list.stream()
                .map(String::toUpperCase)
                .toList();
        assertThat(list).containsExactly("APPLE", "BANANA", "KIWI");
    }

    @Test
    void 가공하기_mapping_람다() {
        List<String> list = Arrays.asList("apple", "banana", "kiwi");
        list = list.stream()
                .map(str -> str.substring(1))
                .toList();
        assertThat(list).containsExactly("pple", "anana", "iwi");
    }

    @Test
    void 가공하기_sort() {
        List<Integer> list = Arrays.asList(23, 5, 1, 2);
        list = list.stream()
                .sorted()
                .toList();
        assertThat(list).containsExactly(1, 2, 5, 23);
    }

    @Test
    void 가공하기_sort_람다() {
        List<String> list = Arrays.asList("apple", "banana", "kiwi");
        list = list.stream()
                .sorted((a, b) -> a.length() - b.length())
                .toList();
        assertThat(list).containsExactly("kiwi", "apple", "banana");
    }

    @Test
    void 가공하기_filter() {
        List<String> list = Arrays.asList("a", "b", "b", "c");
        list = list.stream()
                .filter("b"::equals)
                .toList();
        assertThat(list.size()).isEqualTo(2);
    }
    @Test
    void 결과만들기_calculate() {
        assertThat(IntStream.of(3, 1, 5, 9).count()).isEqualTo(4);
        assertThat(IntStream.of(1, 3, 5, 9).sum()).isEqualTo(18);

        assertThat(IntStream.of(1, 3, 5, 9).max().getAsInt()).isEqualTo(9);
        assertThat(IntStream.of(1, 3, 5, 9).min().getAsInt()).isEqualTo(1);
    }

    @Test
    void 결과만들기_collecting_joining() {
        List<String> list = Arrays.asList("apple", "banana", "kiwi");
        String result = list.stream()
                .collect(Collectors.joining(","));
        assertThat(result).isEqualTo("apple,banana,kiwi");

        result = list.stream()
                .collect(Collectors.joining(",", "[", "]"));
        assertThat(result).isEqualTo("[apple,banana,kiwi]");
    }
}
