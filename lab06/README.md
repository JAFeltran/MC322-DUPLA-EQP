# Arquivos Java do Jogo
  
Para acionar o jogo, execute a classe AppMundoWumpus.java, passando como parâmetro o caminho de um arquivo .csv com as instruções para a criação da caverna,
com cada linha representando uma sala. Na primeira coluna ficam as cordenadas no formato (x:y), com x representando a linha e y a coluna, iniciando na posição "1:1" e finalizando em "4:4". Na segunda coluna ficam as representações do conteúdo das salas, com "P" representando o personagem jogador, "B" um buraco, "W" o monstro
Wumpus, "O" o ouro e "_" uma sala vazia. Para jogar, devem-se usar os comandos a seguir:
* w -> Herói se movimenta para a sala acima
* s -> Herói se movimenta para a sala abaixo
* d -> Herói se movimenta para a sala a direita
* a -> Herói se movimenta para a sala a esquerda
* k -> Herói equipa a flecha e, na próxima sala, a atira, independentemente do que estiver nela. Caso o Wumpus esteja na sala, há uma chance de derrotá-lo
* c -> Herói captura o ouro (se houver ouro na sala)
* q -> O usuário sai do jogo

[Os arquivos java estão aqui!](src/mc322/lab06)
