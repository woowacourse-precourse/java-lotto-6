## 프로젝트 소개
로또를 구입과 당첨을 시뮬레이션 할 수 있는 프로그램입니다.

## 주요 기능 Flow
로또 구입 -> 랜덤 로또 번호 생성 -> 당첨 로또 번호 입력 -> 보너스 번호 입력 -> 당첨 결과 출력 -> 수익률 출력

## 프로그램 설계
- MVC 패턴 구조로 Model, Controller, View 패키지로 설계.
- record로 구현한 DTO를 활용하여 Model과 View의 의존성 분리.
- ENUM으로 예외 메시지, 로또 상수, 순위 상수 구현.
- 인터페이스 NumberGenerator 를 사용하여 의존성 분리.


## 패키지 구조
```markdown
lotto
├── Application.java
├── constant
│   ├── LottoConstant.java
│   └── Rank.java
├── controller
│   └── LottoController.java
├── convertor
│   └── Convertor.java
├── domain
│   ├── AnswerLotto.java
│   ├── Lotto.java
│   ├── LottoFactory.java
│   ├── Money.java
│   ├── NumberGenerator.java
│   ├── RandomNumberGenerator.java
│   └── Result.java
├── dto
│   ├── ResultDto.java
│   └── ResultsDto.java
├── exception
│   ├── ErrorMessage.java
│   ├── InvalidTypeException.java
│   └── LottoException.java
└── view
├── InputView.java
└── OutputView.java
```

## 세부 기능 목록
### Controller
- #### LottoController
- [x] 게임 실행
- [x] 로또 구입 금액 입력 후 예외시 반복
- [x] 로또 당첨번호 입력 후 예외시 반복
- [x] 로또 보너스번호 입력 후 예외시 반복
### Model
- #### LottoFactory
- [x] 금액에 맞는 로또 발행
- [x] 금액 양수 검증
- [x] 금액 1000 단위 검증
- [x] 당첨 등수 별 수량 매핑
- #### Lotto
- [x] 번호 6개 검증
- [x] 번호 중복 여부 검증
- [x] 번호 1 ~ 45 인지 검증
- [x] 보너스 번호 검증
- [x] 보너스 번호 포함 여부 판별
- [x] 다른 로또와 중복 숫자 갯수 카운트
- #### RandomNumberGenerator
- [x] 로또 번호 1~45 중복 안되는 6개 생성
- #### Result
- [x] 수익률 계산
- [x] 전체 수익 계산
- [x] 구입 금액 계산
- #### AnswerLotto
- [x] 등수 계산
### View
- #### InputView
- [x] 로또 구입 금액 입력 받기
- [x] 당첨 번호 입력받기
- [x] 보너스 번호 입력받기
- #### OutputView
- [x] 로또 갯수 만큼 로또 번호 출력
- [x] 당첨 내역 결과 출력
- [x] 수익률 출력
#### Convertor
- [x] 문자를 숫자로 변환
- [x] 문자 숫자인지 검증
- [x] 문자를 숫자 리스트로 파싱
