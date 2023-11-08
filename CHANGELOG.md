#### 2023-11-08

##### Chores

* **CHANGELOG:**  generate initial CHANGELOG.md (765762c9)

##### Documentation Changes

* **README:**
  *  add checkboxes for feature tracking (85d9c86b)
  *  refine input sections for clarity (8c91485e)
  *  implement features list (69a27596)

##### New Features

* **Game:**
  *  add showReturnRate method for display in returnRate (9c07522a)
  *  implement generateBonus method for bonus number processing (37d0fdb3)
  *  implement answer number input logic (9782d8c0)
  *  implement lottos generation logic (9fa29457)
* **Result:**  implement generateResultMessage method for lotto results (6178e54f)
* **Validator:**
  *  add isAnswerInRange method for range checking (d4cfa6e2)
  *  validate purchase amount to be a multiple of 1000 (ed6c3b9e)
* **Lotto:**  add validation for duplicate numbers in lotto ticket (773081ed)
* **buyLotto:**  implement buyLotto method (709c343d)
*  setup precourse lotto project (666a0907)

##### Bug Fixes

* **View:**  implement error message display and input retry mechanism (9b778bc1)
* **Game:**  correct generateAnswer and generateBonus methods with validation (2351dc59)
* **Validator:**  correct condition in notThousands to check divisibility (4c979b25)
* **Message:**  add prompt for user input in inputString method (8bc5ed73)

##### Refactors

* **Errors:**  consolidate error messages in Errors class (64909ad9)
* **Game:**  copy unsorted List to ArrayList (5fc8e41b)
* **constants:**  collect code strings and constants in the 'constants' package (b51b69b8)
* **View:**  rename Message class to View for clarity (961b1d5c)
* **Validator:**  consolidate duplicate validation logic (3e3a4b74)
* **Lotto:**  move Lotto class to model package (0b825198)

##### Tests

* **LottoTest:**
  *  add unit test for calculating return rate in Result (425c06b3)
  *  add unit test for lotto result calculation (540e34ec)
  *  correct test input for bonus number range validation (7c7cfbfa)
  *  add check for winning number being out of valid range (bbf6c291)
  *  add test for bonus number range validation (c23c0c93)
  *  ensure exception for non-numeric bonus number (e02db71f)
  *  add test for non-numeric answer validation (c96fc540)
  *  add test for converting Lotto numbers to String array (522f66e3)
  *  ensure purchase amount must be in thousands (804f3767)
  *  add test for non-numeric input in cost validation (fa07a807)

#### 2023-11-04

##### New Features

*  setup precourse lotto project (666a0907)

