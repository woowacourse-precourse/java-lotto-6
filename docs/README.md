# 🎲 [로또] 구현할 기능 목록
## 프로젝트 구조
- ### Controller
  - LottoGame: 게임의 전반적인 흐름을 제어
- ### Domain (model)
  - Lotto: 로또의 데이터 저장
  - Lottos: 일급 컬렉션
  - LottoGenerator: 로또 생성기
  - Money: 돈
  - Judgement: 로또 당첨 판단
  - WinningPrize: 당첨 값
- ### View
  - ConsoleInput
  - ConsoleOutput
---
## 기능 목록
- [x] **구입할 금액을 입력 받음.** 
  - 예외처리(음의 수) -> `IllegalArgumentException`
  - 예외처리(1,000원으로 나누어 떨어지지 않는 경우) -> `IllegalArgumentException`
 
 
- [x] **구입 금액에 해당하는 만큼 로또를 발행.** 
  - 로또 숫자의 범위는 1~45
  - 중복되지 않는 6개의 숫자를 뽑아야 함.
 
 
- [ ] **당첨 번호 및 보너스 번호 입력 받음.**
  - 예외처리(로또 범위 벗어남) -> `IllegalArgumentException`
  - 예외처리(누락된 값) -> `IllegalArgumentException`
  - 예외처리(중복된 값) -> `IllegalArgumentException`
 
 
- [ ] **로또 당첨 계산 및 출력**
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
 
 
- [ ] **수익률 계산**

---
