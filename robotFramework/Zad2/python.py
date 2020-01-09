def recognize_figure(A,B,C,D): 
  A = int(A)
  B = int(B)
  C = int(C)
  D = int(D)

  if  A <= 0 or B <= 0 or C <= 0 or (D and D <= 0):
    return "Bledna dlugosc bokow"

  maxOfSides = max(A, B, C, D)
  sumOfSides = A + B + C + D
  
  # Czworobok
  if (D):
    if A == B and B == C and C == D:
      return "Kwadrat"
    
    if A == C and B == D:
      return "Prostokat"

    if maxOfSides < (sumOfSides - maxOfSides):
      return "Czworobok"

    return "Nierozpoznano"

  # Trojkat
  if A == B == C:
    return "Trojkat rownoboczny"

  if A == B:
    return "Trojkat rownoramienny"

  if A + B > C and B + C > A and A + C > B:
    return "Trojkat"

  return "Nierozpoznano"

