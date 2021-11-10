
''''
 *Problema 1237- Esperto o Bastante *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
''''


Montadoras = []
Min = []
Max = []
T = int(input())

def checa(p):
    global Montadoras
    global Min
    global Max
    
    answ = -1
    for i in range(len(Min)):
        if(Min[i] <= p and Max[i] >= p):
            if(answ == -1):
                answ = i
            else:
                print("UNDETERMINED")
                return
    if(answ == -1):
        print("UNDETERMINED")
        return
    else:
        print(Montadoras[answ])

for t in range(T):
    
    Montadoras = []
    Min = []
    Max = []
    
    D = int(input())
    
    for d in range(D):
        line = input()
        line = line.split(' ')
        Montadoras.append(line[0])
        Min.append(int(line[1]))
        Max.append(int(line[2]))

    P = int(input())
    
    for p in range(P):
        checa(int(input()))
        
    if(t+1 != T):
        print("")
