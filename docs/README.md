# Feature Specification

## *Input Preview*

- [❌] 구입금액 *credit* 입력받기
- [❌] 당첨번호 *numbers* 입력받기
    - comma로 구분할 수 있어야 한다
    - 각 숫자는 1 ~ 45 사이의 범위를 가지며 중복을 허용하지 않는다
- [❌] 보너스 번호 *BonusNumber* 입력받기
    - 마찬가지로 1 ~ 45 사이의 범위를 가지며, 당첨번호와 중복을 허용하지 않는다

## *Output Preview*

- [❌] *credit*에 맞는 개수 *n* 개를 계산하고, 구입개수 *n* 출력하기
- [❌] *n*의 개수만큼 랜덤 로또 번호를 생성한 뒤 이를 출력하기
    - 오름차순으로 출력한다
- [❌] 당첨 통계 출력하기
- [❌] 당첨 통계에 따른 수익률 출력하기 "총 수익률은 xx.xx%입니다."
    - 소수점 2번째 자리에서 반올림한다

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

- [❌] 사용자의 구입 금액 입력 받기
- [❌] 구입 금액에 따른 로또 번호 생성
    - 이때, 번호는 오름차순으로 출력해야 한다
- [❌] 구입 금액이 유효한지 검증


**class** *Lotto*

- [❌] 당첨 번호 입력 받기
- [❌] 보너스 번호 입력 받기
- [❌] 입력된 당첨 번호가 유효한지 검증
- [❌] 보너스 번호가 유효한지 검증

**class** *Result*
- [❌] 입력값들을 바탕으로 당첨 통계를 계산
- [❌] 계산된 당첨 통계를 출력
- [❌] 당첨 통계를 바탕으로 수익률 계산
- [❌] 수익률 출력

**test** *LottoManagerTest*
- [❌] 대응하는 각 메서드에 대한 UnitTest
**test** *LottoTest*
- [❌] 대응하는 각 메서드에 대한 UnitTest
**test** *ResultTest*
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

