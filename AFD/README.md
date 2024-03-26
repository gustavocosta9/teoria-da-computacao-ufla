# Autômato Finito Determinístico ⚪➖🔘

## Definição Formal

Um Autômato Finito Determinístico A é uma **5-tuple (ou quíntupla), (Q, Σ, δ, q0, F)** consistindo de:

- um conjunto finito de símbolos de entrada chamado Alfabeto (Σ)
- um conjunto finito de estados (Q)
- uma função de transição (δ : Q × Σ → Q)
- um estado inicial (q0 ∈ Q) e
- um conjunto de estados de aceitação (F ⊆ Q)

Seja w = a1a2 ... an uma cadeia de símbolos sobre o alfabeto Σ, O autômato M aceita a cadeia w se somente se existe uma sequência de estados, r0,r1, ..., rn, em Q com as seguintes condições:

- r0 = q0
- ri+1 = δ(ri, ai+1), para i = 0, ..., n−1
- rn ∈ F.

Em outras palavras, a primeira condição afirma que a máquina se inicia no estado inicial q0. A segunda condição diz que, dado cada símbolo da entrada w, a máquina transita de estado em estado de acordo com a função de transição δ. A terceira e última condição diz que a máquina aceita w se somente se o último símbolo da entrada leva o autômato a parar em um estado f tal que f ∈ F. Caso contrário, diz-se que a máquina rejeita a entrada. O conjunto de cadeias que M aceita é chamado Linguagem reconhecida por M e é simbolicamente representado por L(M).

*fonte: Wikipédia.*

****
## Entendendo o código⚙️
 O código foi dividido em três arquivos:

 - **App.java**: arquivo responsável por obter os dados do usuário via terminal, além disso, também é o arquivo que instanciará o Autômato e imprimirá na tela as validações.
 - **Automato.java:** é o arquivo que possui a classe Autômato, é nela onde criei todas as características de um autômato (estados, alfabeto, funções de transição, etc).
 - **Chave.java:** é uma classe que, na verdade, representa uma **tupla** que será utilizada em conjunto com a estrutura de dados Map para realizar as funções de transição.

### App.java

De início, há simplesmente algumas perguntas realizadas ao usuário que correspondem aos elementos da quíntupla do Autômato Finito Determinístico, exceto as funções de transição. Isso ocorre porque, antes do recebimento das funções de transição, as variáveis: *estados, alfabeto, estadosFinais e o estadoInicial* serão os parâmetros para a instanciação do AFD.


<img src="https://i.ibb.co/zZq420P/Captura-de-tela-2024-03-26-001613.png">


Aqui está a instanciação de um AFD logo após o recolhimento dos dados necessários para a sua criação via terminal (System.in).

<img src="https://i.ibb.co/SmqW2vh/Captura-de-tela-2024-03-26-002052.png">

Após a sua instanciação, é chamado o método da classe: *receberFuncoesTransicao* que vai requisitar ao usuário que digite as funções de transição desse AFD, como parâmetro está sendo passado o único scanner do programa, para que ele possa coletar os dados dentro do escopo do método.

<img src="https://i.ibb.co/c2NX3dp/Captura-de-tela-2024-03-26-002337.png">


Como parte final do arquivo App.java, há apenas um loop while que serve para o usuário testar inúmeras palavras de sua vontade até que a palavra 'exit' seja digitada para finalizar o programa. É aqui que será chamado um método do AFD instanciado que é responsável por verificar se a palavra é aceita ou não.

<img src="https://i.ibb.co/yVMQDsP/Captura-de-tela-2024-03-26-002515.png">

### Automato.java

É o arquivo que contém a parte lógica do programa e todo o funcionamento de um AFD. Foi criada uma classe com atributos que são indispensáveis para a criação desse AFD, são eles:

- *Set<String> estados:* é o conjunto de estados do autômato, é do tipo (em java, da classe) String.
- *Set<String> alfabeto:* é o alfabeto do autômato, é do tipo (em java, da classe) String.
- *final String estadoInicial:* é o estado inicial do autômato, uma vez instanciado e informado pelo usuário o seu valor é imutável.
- *Set<String> estadosFinais:* é o conjunto de estados finais do autômato, é do tipo (em java, da classe) String.
- *Map<Chave<String,String>, String> funcoesTransicao:* é um Map do Java, ou seja, ele é uma estrutura do tipo Chave-Valor que tem como chave uma Tupla de Strings e um valor de String.

O construtor do autômato AFD instancia todas as estruturas de dados dos atributos para seguir as boas práticas do Java, além disso, é dentro do construtor que os outros atributos serão preenchidos com os próprios **metodos da classe, repare que esses são todos private para uso exclusivo da classe**.

<img src="https://i.ibb.co/gVy0ddK/Captura-de-tela-2024-03-26-003929.png">

<img src="https://i.ibb.co/tCS3Ypr/Captura-de-tela-2024-03-26-004027.png">

Logo em seguida, há os gets da Classe que foram úteis apenas para fins de depuração, principalmente no que se diz respeito ao Map onde foi preciso utilizar estruturas aninhadas.

<img src="https://i.ibb.co/7RTkyNJ/Captura-de-tela-2024-03-26-004134.png">

Agora, há os métodos criados para tratamento das entradas digitadas pelo usuário, visto que, quando o usuário insere os estados, o alfabeto, etc, todos esses atributos estão em uma só String, logo foi necessário realizar um split para colocar cada estado e símbolo em seu devido conjunto.

<img src="https://i.ibb.co/tcVt4K1/Captura-de-tela-2024-03-26-004339.png">

<img src="https://i.ibb.co/YfcnKm0/Captura-de-tela-2024-03-26-004602.png">

<img src="https://i.ibb.co/F6bbLDY/Captura-de-tela-2024-03-26-004610.png">

Após esses métodos de tratamento, há o método de recebimento das funções de transição pelo usuário via terminal, como dito anteriormente, é passado o scanner como parâmetro para que seja possível realizar as entradas e para não ocasionar em problemas de *memory leakage* ou problemas como *NullExceptionPointer* só foi utilizado um scanner em todo o código.
A lógica é a seguinte: após a coleta dos estados e do alfabeto, há um for aninhado para que seja construída toda combinação possível de (estadoAtual, símbolo). Dessa forma, com as tuplas formadas, o usuário digitará qual será o *estado destino* correspondente à tupla informada naquele momento. Vale ressaltar também, que caso não haja nenhum estado Destino para tal combinação, o usuário deverá digitar *'none'* indicando que não há transição para aquele estado ao receber tal símbolo. Para cada iteração aninhada, será instanciada uma chave do tipo Chave (que é uma tupla) cujo nome da chave será a **combinação** do estado atual e do simbolo atual, no próximo passo, basta realizar o tratamento: caso o usuário digite *'none'* coloque o no **Map funcoesTransicao** a chave criada e como valor uma String vazia, se não, coloque a chave criada e o estado Destino.

<img src="https://i.ibb.co/qR6L6b4/Captura-de-tela-2024-03-26-085510.png">

Por fim, o método da classe *verificacao* recebe uma palavra digitada pelo usuário, é o método responsável por realizar o reconhecimento ou a rejeição da palavra. A lógica por trás desse método é: 

- Inicialize o estadoAtual com o mesmo valor do estadoInicial;
- converta a palavra do usuário para um vetor de char, após isso, percorra char a char, formando combinações de chave do estadoAtual e do char 'c' guardando os valores na variável proximoEstado;
-  caso o próximo estado seja 'none', significa que não há transição do estadoAtual para outro, então rejeite a palavra;
-  caso haja transição válida, atualize o estadoAtual com o valor do próximoEstado que acabou de ser verificado;
-  após todas as iterações, se no conjunto de estados finais há o último valor armazenado na variável estadoAtual (que representa, supostamente, o estado final) aceite a palavra;
-  caso contrário, rejeite a palavra.

<img src="https://i.ibb.co/b7grVV2/Captura-de-tela-2024-03-26-090618.png">

### Chave.java

Nada de diferente do padrão para a criação de uma tupla em Java, consiste apenas na classe do tipo tupla que receberá dois valores que será a chave de um elemento do Map.


## Exemplo de uso⚙️

### Exemplo 01

L = palavras sobre {a,b} que começam e terminam com 'a' e possuem pelo menos um 'b'.

<img src="https://i.ibb.co/rwHBzH9/Captura-de-tela-2024-03-26-092314.png">

**Vamos construir esse AFD no programa:**

Inserção dos dados do AFD, atente-se para as funções de transição e os estados, como utilizei a interface HashMap ela não conserva a ordem de inserção de estados no terminal!

<img src="https://i.ibb.co/QXc3721/Captura-de-tela-2024-03-26-092732.png">

Agora é o momento da verificação da palavra digitada pelo usuário, vamos olhar algumas palavras inseridas e seus respectivos resultados.

<img src="https://i.ibb.co/ygvvS2x/Captura-de-tela-2024-03-26-093112.png">

### Exemplo 02

L = palavras sobre {a,b} que contém 'aa' ou 'bb'.

Inserção do AFD no terminal.

<img src="https://i.ibb.co/KwZW2gp/Captura-de-tela-2024-03-26-095620.png">

Verificação de palavras digitadas pelo usuário.

<img src="https://i.ibb.co/W6zS8Rw/Captura-de-tela-2024-03-26-095917.png">


****

## Projeto Java 📁

O ambiente do projeto está configurado no modo padrão do VS Code:

- `src`: é a pasta que possui os arquivos de código;
- `lib`: é a pasta que tem as dependências do projeto.

Ademais, os arquivos compilados serão gerados por padrão na pasta *bin*

