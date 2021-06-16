# Projeto "O Herói das Eras"

# Descrição do Projeto

300.000 anos antes da era comum, nasce um guerreiro.

Este rapaz está destinado, pelas forças da natureza, a lutar contra o mal ao
longo das centenas de milhares de anos da existência da humanidade.

Abençoado pelas moiras, três mulheres responsáveis por fabricar, tecer e cortar 
o fio da vida dos homens, somente aqueles que descendem do mal podem matá-lo.

Conseguirá o herói cumprir sua missão? Isso depende somente de você...


# Equipe

* Fábio de Andrade Barboza - RA 168817
* João Augusto Rosa Feltran - RA 174083

# Estrutura de Arquivos e Pastas

~~~
├── README.md          <- apresentação do projeto
│
├── assets             <- mídias usadas no projeto
│
├── data               <- dados usados pelo jogo
│
└── src                <- projeto em Java 
    │
    ├── bin            <- arquivos em bytecode (.class)
    │
    ├── src            <- arquivos-fonte do projeto (.java)
    │
    └── README.md      <- instruções básicas de instalação/execução
~~~

# Vídeos

## Vídeo da Prévia

[Vídeo da prévia](https://drive.google.com/file/d/1uszDQPCGeER__hJ6rSXI5SbTS8QNMBl6/view?usp=sharing)

# Slides

## Slides da Prévia

[Slides da prévia](https://drive.google.com/file/d/16Q0duAxH0vFAeqShCByhoIEvQyzOdOX1/view?usp=sharing)

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

![Diagrama Geral do Projeto](link do diagrama)

O jogo foi planejado com base no estilo "Model-View-Control". O Jogador tem acesso a um painel ("View"), que apresenta um Mapa e seus Atores("Model") ao Jogador e permite que este se mova e interaja com outros Atores ("Control"). 

## Componente Ator
    
## Componente Ator Visual

## Componente Mapa

## Componente Mapa Visual

## Componente Montador

## Componente Controle

## Componetne Painel

# Plano de Exceções

## Diagrama da hierarquia de exceções

![Hierarquia de Exceções](link do diagrama)

## Descrição das classes de exceção

Classe | Descrição
----- | -----
IOException | Verifica se o arquivo foi aberto corretamente.
TamanhoInvalido | Indica que o arquivo .CSV lido não tem um tamanho adequado para criar um mapa.
MapaInvalido | Indica que o mapa armazenado no arquivo .CSV é inválido.
    
    
    
    
    
    
    
    


## Componente `<Nome do Componente>`

Resumo do que faz 

![Componente Ator](link do componente)

**Ficha Técnica**
Item | Detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

### Interfaces

![Diagrama Interfaces](link do diagrama)

Interface agregadora do componente em Java:

~~~java
public interface BLA BLA BLA {
}
~~~

### Interface `<Nome da Interface>`

Resumo do que faz

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`
