import math

'''
 * Problema 860 Analisador de Entropia Textual
(Entropy Text Analyzer)*

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
'''

'''
2.1	Método dicionárioFreq
Objetivo:
A partir de um texto em forma de lista de palavras,
gerar um dicionário com a frequência de cada palavra

Entrada:
Texto em forma de lista de palavras

Saída:
Dicionário onde cada palavra é atrelada a um número de
ocorrências da mesma no texto
'''
def dicionarioFreq(texto):
	dicionario = {}
	for termo in texto:
		dicionario[str(termo)] = 0
	for termo in texto:
		dicionario[termo] = dicionario.get(str(termo)) + 1
	return dicionario




'''
2.2	Método tokeniza
Objetivo:
A partir de uma sentença em forma de string, gerar uma
lista de palavras

Entrada:
Texto em forma de string

Saída:
Texto em forma de lista de palavras
'''
def tokeniza(sentence):
	frase = ""
	for item in sentence:
		frase += (item + " ")

	frase = frase.replace("\n"," ")
	frase = frase.replace("\t"," ")
	frase = frase.replace(","," ")
	frase = frase.replace("."," ")
	frase = frase.replace(":"," ")
	frase = frase.replace(";"," ")
	frase = frase.replace("!"," ")
	frase = frase.replace("?"," ")
	frase = frase.replace("\""," ")
	frase = frase.replace("("," ")
	frase = frase.replace(")"," ")

	# Foldcase
	frase = frase.lower()
	lista = frase.split()


	return lista



'''
2.3	Método leEntrada
Objetivo:
Ler toda a entrada e armazenar todos os textos

Entrada:
Entrada recebida pela linha de comando

Saída:
Lista de textos em forma de string
'''
def leEntrada():
	textos = []
	documento = []
	linha = []
	while (linha != "****END_OF_INPUT****"):
		linha = input()
		documento.append(linha)
		if(linha == "****END_OF_TEXT****"):
			documento.pop()
			textos.append(documento)
			documento = []


	return textos


'''
2.4	Método Et
Objetivo:
A partir do valor de λ e de um dicionário de frequência
de palavras, calcular o valor da entropia Eᴛ do texto
relacionado ao dicionário

Entrada:
Valor de λ do texto
Dicionário de frequência de palavras

Saída:
Valor da entropia Eᴛ do texto

'''
def Et(lambida,dicionario):
	
	somatorio = 0
	for palavra in dicionario:
		pi = dicionario[palavra]
		soma = pi*(math.log(lambida,10) - math.log(pi,10))
		somatorio+=soma
	et = (1/lambida) * somatorio
	return et


'''
2.5	Método Emax
Objetivo:
A partir do valor de λ, calcular o valor da entropia máxima
Emax de um texto

Entrada:
Valor de λ do texto

Saída:
Valor da entropia máxima Emax do texto
'''
def Emax(lambida):	
	somatorio = 0
	for i in range(lambida):
		somatorio+=(math.log(lambida,10))

	emax = (1/lambida) * somatorio
	return emax



'''
2.6	Método Erel
Objetivo:
A partir do valor da entropia Eᴛ do texto e o valor da entropia
máxima Emax do texto, calcular o valor da entropia relativa
Erel do texto

Entrada:
Valor da entropia Eᴛ do texto
Valor da entropia máxima Emax do texto

Saída:
valor da entropia relativa Erel do texto
'''
def Erel(et,emax):
	return (et / emax) *100 


'''
2.7	Método main
Objetivo:
Executar todos os métodos descritos de forma sequencial para
cada um dos textos de entrada, a fim de obter os valores
requisitados pelo enunciado e mostrá-los adequadamente
a cada iteração

Entrada:
Entrada recebida pela linha de comando

Saída:
Mostrar na tela os valores de λ, Eᴛ e Erel, conforme
as especificações do enunciado
'''
def main():


	textos = leEntrada()
	for texto in textos:
		texto = tokeniza(texto)
		dicionario = dicionarioFreq(texto)
		# print(dicionario)
		# print(dicionario)
		lambida = len(texto)
		et = Et(lambida,dicionario)
		emax = Emax(lambida)
		erel = Erel(et,emax)
		print(lambida, end =" ")
		print(round(et,1), end =" ")
		print(round(erel))
		# print(sorted(dicionario))

	# print(textos)
	# print(texto)
	

	# lambida pq lambda é palavra reservada
	# lambida é a quantidade de palavas que um texto possui


# Executar main
main()
