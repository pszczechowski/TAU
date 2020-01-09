*** Settings ***
Library  python.py

** Variables ***

** Test Cases ***

Equilateral Triangle Recognize
  Check Figure  Trojkat rownoboczny  4  4  4  0

Isosceles Triangle Recognize
  Check Figure  Trojkat rownoramienny  3  3  4  0

Triangle Recognize
  Check Figure  Trojkat  4  5  6  0

Square Recognize
  Check Figure  Kwadrat  2  2  2  2

Rectangle Recognize
  Check Figure  Prostokat  2  3  2  3

Quadrangle Recognize
  Check Figure  Czworobok  2  3  4  5

Unrecognized Quadrangle
  Check Figure  Nierozpoznano  2  3  3  12

Unrecognized Triangle
  Check Figure  Nierozpoznano  3  7  61  0

Wrong Sides Length
  Check Figure  Bledna dlugosc bokow  3  -1  5  0

*** Keywords ***
Check Figure
  [Arguments]  ${word}  ${sideA}  ${sideB}  ${sideC}  ${sideD}
  ${results} =  recognize figure  ${sideA}  ${sideB}  ${sideC}  ${sideD}
  Should Be Equal  ${results}  ${word} 