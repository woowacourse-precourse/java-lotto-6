# Stream
https://futurecreator.github.io/2018/08/26/java-8-streams/

- Stream의 장점
  for문을 사용했다면 읽은 사람으로 하여금 읽다가 다시 위로 올라가서 읽으니까 읽기 쉽지 않을 수 있다. 하지만 stream은 생각하기 쉽다.
  `list -> "b"와 같은 것을 찾은 list -> list를 조인한 문자열` 이런식으로 뒤로 돌아가지 않고 직관적으로 코드를 해석할 수 있다는 장점이 있다.
  그리고 병렬처리가 가능하다. for 문을 통해서 하나하나 계산하는 방식에 비해 Stream은 요소를 쪼갠 뒤에 멀티스레드를 이용해서 더욱 빠르게 계산이 가능하다.
## 생성하기
```java
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
}
```
- 배열로 생성하기 위해 `Arrays.stream`를 이용했다.
- List 콜렉션에는 기본적으로 `stream()`이 존재한다.
- 스트림 빌더를 통해 서로 다른 요소를 추가한 뒤 스트링을 생성할 수 있다.

## 가공하기
### mapping
```java
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
```
- 매핑을 통해 스트림 안의 요소들을 변경시킬 수 있다.
- 람다식을 이용해서 더욱 많은 변경을 할 수 있다.
### sort
```java
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
```
- 스트림 안의 요수들을 정렬시킬 수 있다.
- sort도 마찬가지로 람다식을 통해 정렬 규칙을 더욱 자세하게 정의할 수 있다.
### filter
```java
@Test
void 가공하기_filter() {
    List<String> list = Arrays.asList("a", "b", "b", "c");  
    list = list.stream()  
            .filter("b"::equals)  
            .toList();  
    assertThat(list.size()).isEqualTo(2);
} 
```
- 필터를 통해 리스트 안의 요소 중 조건에 맞지 않는 요소들을 필터링할 수 있다.
## 결과 만들기
### calulate
```java
@Test  
void 결과만들기_calculate() {  
    assertThat(IntStream.of(3, 1, 5, 9).count()).isEqualTo(4);  
    assertThat(IntStream.of(1, 3, 5, 9).sum()).isEqualTo(18);  
  
    assertThat(IntStream.of(1, 3, 5, 9).max().getAsInt()).isEqualTo(9);  
    assertThat(IntStream.of(1, 3, 5, 9).min().getAsInt()).isEqualTo(1);  
}
```
- IntStream은 count / sum / max / min 등 여러 기본적인 계산을 제공한다.
### joining
```java
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
```
- `String.join` 과 같이 문자열 사이에 문자를 끼워서 문자열로 리턴시킬 수 있다.
- 추가적으로 문자열의 처음과 끝에 원하는 문자를 배치시킬 수 있다.