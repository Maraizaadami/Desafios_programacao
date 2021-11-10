''''
 *Problema 1368- Consenso de DNA *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
''''

def moda(k):
    ACGT = [0, 0, 0, 0]
    text = ['A', 'C', 'G', 'T']
    
    for i in range(len(fitas)):
        tmp = fitas[i][k]
        
        if(tmp == 'A'):
            ACGT[0] += 1
        if(tmp == 'C'):
            ACGT[1] += 1
        if(tmp == 'G'):
            ACGT[2] += 1
        if(tmp == 'T'):
            ACGT[3] += 1
        
    return (text[ACGT.index(max(ACGT))], len(fitas) - max(ACGT))


T = int(input())

for t in range(T):
    text = input()
    text = text.split()
    
    Qtd = int(text[0])
    Tam = int(text[1])
    
    fitas = []
    
    for q in range(Qtd):
        fitas.append(input())
    
    answ = ""
    erroTotal = 0
    
    for i in range(Tam):
        char, erros = moda(i)
        answ += char
        erroTotal += erros
        
    print(answ)
    print(erroTotal)
