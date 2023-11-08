# Feature Specification

## Details
로또 게임을 진행하는 프로그램입니다.
사용자로부터 1000원 단위의 금액을 입력받은 뒤 이를 바탕으로 랜덤 숫자(1~45사이 중복없는 자연수)를 생성하고, 
오름차순으로 출력합니다.
이어서 당첨 금액과 보너스 번호를 입력받은 뒤 사용자에게 생성된 숫자와 대조하여 당첨 통계와 수익률을 냅니다. 
사용자의 입력이 올바르지 못 한 경우, [Error] 메세지를 출력하고 다시 입력할 수 있도록 합니다.

실행 예시
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## Class

**class** *LottoManager*
- [❌] 실행 흐름 관리하기
- [❌] 구입 금액에 검증
- [❌] 구매
- [❌] 로또 생성

**class** *User*
- [❌] 구매 금액 입력 받기
- [❌] 당첨 번호 입력 받기
- [❌] 보너스 번호 입력 받기

**class** *Lotto*
- [✅] 당첨 번호 입력 받기
- [✅] 입력된 당첨 번호가 유효한지 검증

**class** *WinningNumber*
- [✅] 보너스 번호 입력 받기
- [✅] 보너스 번호의 유효성 검증

**class** *Calculation*
- [❌] 입력값들을 바탕으로 당첨 통계를 계산
- [❌] 당첨 통계를 바탕으로 수익률 계산
- 
**class** *Result*
- [❌] 구입 금액에 따른 로또 개수 출력
- [❌] 로또 개수에 따른 각 로또 번호 출력
- [❌] 계산된 당첨 통계를 출력
- [❌] 수익률 출력

**test** *LottoManagerTest*
- [✅] 대응하는 각 메서드에 대한 UnitTest

**test** *LottoTest*
- [✅] 대응하는 각 메서드에 대한 UnitTest
- 
- **test** *WinningNumberTest*
- [✅] 대응하는 각 메서드에 대한 UnitTest
- 
**test** *CalculationTest*
- [❌] 대응하는 각 메서드에 대한 UnitTest

**test** *ApplicationTest*
- [❌] 시스템이 잘 동작하는 지에 대한 Test
## The Rule of Commit Messages

> [title]\: [brief description] <br>
> [specific description]

| title     | description                                            |
|-----------|--------------------------------------------------------|
| init      | configuration (install package etc)                    |
| implement | implement large-scale features                         |
| add       | add a new feature                                      |
| fix       | fix a bug (in: location, for: reason)                  |
| remove    | remove (from: location)                                |
| move      | move code or files                                     |
| rename    | change the name of something                           |
| hotfix    | fix a critical bug                                     |
| refactor  | refactor code                                          |
| chore     | miscellaneous tasks such as comments, formatting, etc. |
| docs      | write or update documentation                          |

