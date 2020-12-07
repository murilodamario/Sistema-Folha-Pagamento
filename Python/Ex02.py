'''
Fatec Campinas - Análise e desenvolvimento de sistemas
Dupla:
  Giovanni Rafael Mota
  Murilo Gomes da Costa Damario
'''
import random

#Classe Animal
class Animal():
  def __init__(self, genero, deslocar):
    self.genero = genero
    self.deslocar = deslocar
    
  def get_genero(self):
    return self.genero
    
  def set_genero(self, genero):
    self.genero = genero

  def get_deslocar(self):
    return self.deslocar
    
  def set_deslocar(self, deslocar):
    self.deslocar = deslocar
    
  def get_tipo(self):
    return self.tipo
    
  def set_tipo(self, tipo):
    self.tipo = tipo

#Classe Peixe que herda Animal
class Peixe(Animal):
  def  __init__(self, genero, deslocar):
    super().__init__(genero, deslocar)
    self.tipo = "Peixe"

#Classe Urso que herda Animal
class Urso(Animal):
  def  __init__(self, genero, deslocar):
    super().__init__(genero, deslocar)
    self.tipo = "Urso"

lista_genero = ['macho', 'femea']
rio = []

for i in range(10):
  rio.append(None)

#Instancias dos Peixes e Ursos
rio[1] = Peixe(random.choice(lista_genero), 0)
rio[2] = Urso(random.choice(lista_genero), 0)
rio[3] = Peixe(random.choice(lista_genero), 0)
rio[5] = Peixe(random.choice(lista_genero), 0)
rio[6] = Urso(random.choice(lista_genero), 0)
rio[8] = Urso(random.choice(lista_genero), 0)

for x in range(10):
  print("\nINSTANTE: ", x+1)
  for i in range(10):
    if rio[i] is not None:
      aux = random.randint(0,2)
      if aux == 1 or i == 9:
        rio[i].deslocar = i-1
      elif aux == 2:
        rio[i].deslocar = i+1
      elif aux == 0:
        rio[i].deslocar = i
      print(rio[i].deslocar)

  for i in range(10):
    for j in range(10):
      if i != j:
        if rio[j] is not None and rio[i] is not None:  
          if rio[i].deslocar == rio[j].deslocar:
                        
            #Condicional para animais do mesmo tipo mas de gênero diferente
            if rio[i].genero != rio[j].genero and rio[i].tipo == rio[j].tipo:
              if rio[i].tipo == 'Peixe' and rio[rio[i].deslocar] == None:
                rio[rio[i].deslocar] = Peixe(random.choice(lista_genero), 0)
              elif rio[i].tipo == 'Urso' and rio[rio[i].deslocar] == None:
                rio[rio[i].deslocar] = Urso(random.choice(lista_genero), 0)
                        
            #Condicional para animais de tipos diferentes e se deslocam para o mesmo lugar
            elif (rio[i].tipo != rio[j].tipo):
              if rio[i].tipo == 'Urso':
                rio[j] = None
              else:
                rio[i] = None

          #Condicional para evitar que um animal ande para um lugar ocupado por outro animal
          elif rio[i] is not None and rio[i].deslocar != 10 and rio[i].deslocar != -1:   
            if rio[rio[i].deslocar] == None:
              rio[rio[i].deslocar] = rio[i]
              rio[i] = None

          #Condicional para animais de tipos diferentes e se cruzam em algum lugar
          elif (rio[i].deslocar == j and rio[j].deslocar == i):
            if (rio[i].tipo != rio[j].tipo):
              if rio[i].tipo == 'Urso':
                rio[j] = None
                rio[rio[i].deslocar] = rio[i]
                rio[i] = None
              else:
                rio[i] = None
                rio[rio[j].deslocar] = rio[j]
                rio[j] = None
            else:
              rio_aux = rio[i]
              rio[i] = rio[j]
              rio[j] = rio_aux                    

  for i in range(10):
    if rio[i] != None and rio[i].genero != None and rio[i].tipo != None:
      print(rio[i].tipo + " " + rio[i].genero)
    else:
      print("-")

