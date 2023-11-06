# 로또

## 기능목록

- [ ] Model : 데이터에 대한 순수 로직
    - [X] 입력 받은 구입 금액이 1000의 배수인지 검증.
    - [X] 랜덤 수 6자리 생성
    - [ ] 수익율 계산
    - [ ] 당첨 여부 검증
    - [X] 당첨 번호 적합 검증(Lotto class)
    - [X] 입력 받은 문자열을 적절한 형으로 변환.

- [ ] View : 모델을 통해 전달된 값 출력
    - [ ] 안내 멘트 출력
    - [ ] 자동 게임 번호 출력
    - [ ] 통계 출력
    - [ ] 게임수 출력

- [ ] Control : 중개자
    - [ ] 안내 멘트 호출
    - [ ] 구입 금액 입력
    - [ ] 당첨 번호 입력
    - [ ] 보너스 번호 입력
    - [ ] 로또 티켓 발행

- [X] DTO : 순수 데이터만 담기는 클래스
    - [X] 자동 게임 번호, 구입 금액
    - [X] 당첨 번호, 보너스 번호
    - [X] 수익율 계산 결과
    - [X] 안내 멘트

---

## 기능 요구 사항

1. 구입 금액은 반드시 1000의 배수여야한다. 아닐 시 예외 처리한다. "[ERROR]" 시작하는 에러 메시지 출력. IllegalArgumentException
2. 입력 받는 당첨 번호는 쉼표(,)를 기준으로 구분한다.
3. 보너스 번호를 입력 받는다. (보너스 번호가 먼저 입력 받은 당첨 번호와 중복되지 않는지 체크)
4. 수익률은 소수점 둘째 자리에서 반올림한다.

## 프로그래밍 요구 사항

1. 인덴트는 2까지 허용한다.
2. Java 코드 컨벤션 가이드 준수
3. System.exit() 금지
4. 함수(메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
5. else 금지. if 조건 체크 후 바로 return.
6. Java Enum 사용
7. 단위 테스트 구현
8. Lotto 클래스 반드시 사용. numbers의 private 수정 금지. 인스턴스 변수 추가 금지. 패키지 변경만 가능.

```Java
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

## 과제 진행 요구 사항

1. 구현 전에 README.md 정리
2. 커밋 메시지 컨벤션 지켜 작성