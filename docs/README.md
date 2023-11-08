## 🚀 기능 요구 사항 목록
### 1. 로또 구입 금액 
- [ ] 1000의 배수인 숫자 입력 받기
- [ ] 발행한 로또 수량 출력 하기

### 2. 당첨 번호(번호는 쉼표로 구분)
- [ ] 1 ~ 45 이내의 중복 아닌 정수
- [ ] 발행한 로또 번호 출력(오름차순으로 정렬)

### 3. 보너스 번호
- [ ] 1 ~ 45 이내의 당첨 번호와 중복 아닌 정수

### 4. 당첨 통계
```
당첨 통계
---
3개 일치 (5,000원) - a개
4개 일치 (50,000원) - b개
5개 일치 (1,500,000원) - c개
5개 일치, 보너스 볼 일치 (30,000,000원) - d개
6개 일치 (2,000,000,000원) - e개
```
- a ~ e 제외 출력 형태 고정

- [ ] 수익률은 소수점 둘째 자리에서 반올림

### 5. InputValidator - 예외 처리
- [ ] 예외 상황 시 에러 문구 출력 `[ERROR]`로 시작 -> 다시 입력 받기
- [ ] `IllegalArgumentException`을 상속받은 `LottoGameException`을 각 상황에 맞는 메시지와 함께 발생시킨다.

1. 구입 금액
- 숫자가 아닌 경우
- 음수인 경우
- 1000으로 나누어 떨어지지 않는 경우

2. 당첨 번호
- 쉼표가 맨앞 혹은 맨뒤에 있는 경우
- 쉼표가 중복으로 등장하는 경우
- 공백이 포함된 경우
- split 후 숫자가 아닌 경우
- 1 ~ 45 범위를 벗어난 경우
- 숫자가 중복된 경우

3. 보너스 번호
- 숫자가 아닌 경우
- 음수인 경우
- 당첨 번호와 중복된 경우
- 1 ~ 45 범위를 벗어난 경우


### 📎 추가된 프로그래밍 요구 사항
```
1. 함수의 길이가 15라인 넘지 않도록
2. else 에약어를 쓰지X
3. Java Enum 적용
4. 도메인 로직에 단위 테스트를 구현 (System.out, System.in, Scanner 로직은 제외)
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현
```

라이브러리
`List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);` 사용

Lotto 클래스 사용
- numbers 의 접근 제어자인 private을 변경할 수 없다
- 필드를 추가할 수 없다
- 패키지 변경은 가능

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
```

