# 🎱 로또 게임

## 🚀 기능 목록

- [ ]  로또 구입금액을 입력받는 기능
   - [ ]  1000원으로 나누어 떨어지지 않는 경우 예외처리
- [ ]  발급받은 로또 수량과 번호를 출력하는 기능
   - [ ]  오름차순으로 출력
- [ ]  당첨 번호 6자리를 입력받는 기능(쉼표로 구분)
   - [ ]  번호가 공백일 경우 예외처리
   - [ ]  콤마로 구분되지 않는 경우 예외처리
- [ ]  보너스 번호를 입력 받는 기능
   - [ ]  숫자가 아닌 경우 예외처리
   - [ ]  유효한 숫자를 입력하지 않은 경우 예외처리
- [ ]  당첨번호와 발급받은 번호를 비교하여 통계내는 기능
   - [ ]  번호가 몇개가 일치하는지 계산
   - [ ]  수익률을 계산(소수점 둘째자리에서 반올림)
- [ ]  당첨 결과를 출력하는 기능

## 🔠 프로그래밍 요구사항

- [ ]  Readme 작성에 공들이기
   - [ ]  대문페이지에서 프로젝트 소개하기
   - [ ]  너무 상세하기 작성하지 않기(클래스와 함수 설계 등)
   - [ ]  예외상황 등 계속 수정해 나가며 죽어있는 문서 만들지 않기
- [ ]  함수(메서드) 분리하기
   - [ ]  15라인을 넘어가지 않기
   - [ ]  한 가지 일만 ‘잘’ 하도록 구현
   - [ ]  indent depth가 3이 넘어가지 않도록 구현
- [ ]  테스트코드
   - [ ]  처음부터 큰 단위의 테스트를 만들지 않는다.
   - [ ]  도메인 로직에 단위 테스트를 구현할 것
- [ ]  Else예약어 사용하지 않기
- [ ]  하드코딩 하지 않기
- [ ]  Enum을 적용하기
- [ ]  구현 순서 지키기

  ```java
  class A {
      상수(static final) 또는 클래스 변수
  
      인스턴스 변수
  
      생성자
  
      메서드
  }
  ```

- [ ]  변수 이름에 자료형 사용하지 않기

  ```java
  List<String> stringList = new ArrayList<>();
  ```

- [ ]  예외 상황시 문구를 출력할 것

  ```
  [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
  ```

- [ ]  주어진 API와 클래스를 활용할 것
### API
   ```java
   List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
   ```

```java
Console.readLine();
```
### Class
```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}

// 주어진 코드를 변경하지 않는다.
// 필드 역시 추가 불가
// 패키지 변경은 가능
```

## 📝학습 할 것


> 무엇을 학습하냐도 중요하지만, 학습한 것에 대한 유용성, 코드에 어떻게 적용해 나갈 것인지 등 충분히 고민하면서 학습한다.

- [ ] 테스트 코드
- [ ] 도메인 로직과 비즈니스 로직의 분리(MVC)
- [ ] 의존성