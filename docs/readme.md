# m226a - Adventure Game

## Planung

### Klassendiagramm:

**Klassendiagramm der Planung:**
![Klassendiagramm](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/klassendiagramm.png)

**Klassendiagramm des finalen Produkts:**
![Klassendiagramm Final](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/klassendiagramm1.png)

### Sequenzdiagramm

![Sequenzdiagramm](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/sequenzdiagramm.png)

## Entwicklung

### GameEngine:

Mithilfe der Game Engine konnte ich beispielsweise durch eine Methode die Textausgabe
im Terminal (Farbe, Textstärke) ohne grossen Aufwand festlegen. 

![GameEngineThree](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine3.png)
![GameEngineOne](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine1.png)
![GameEngineTwo](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine2.png)

Ein ähnliches Prinzip verwendete ich, um die Usereingabe verschiedener Commands zu handeln.
![GameEngine Four](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine4.png)
![GameEngine Five](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine5.png)

### Kampfsystem:

Im Spiel kämpft der Spieler gegen zahlreiche Monster mit dem Ziel, die belagerten Schauplätze für sein Königreich zurückzugewinnen.
Ich war mir zunächst unsicher, wie ich diese Mechanik in einem realistischen Rahmen im Spiel implementieren konnte.
Letzendlich entschied ich mich dazu, die Kämpfe in verschiedene (offensive & defensive) Manöver aufzuteilen und die jeweiligen
Manöver zu simulieren. 

Mein Ziel war es, dass der Spieler für jedes Manöver Entscheidung treffen und dadurch seine Siegeschancen beeinflussen konnte.
Leider war es mir zeitlich nicht möglich dieses Feature in seiner vollen Form einzubauen, weshalb der Spieler in der aktuellen Version
lediglich zum Beginn eines jeden Duells zu seinem taktischen Vorgehen befragt wird.

![Combat One](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/combat1.png)
![Combat Two](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/combat2.png)

### Story:

Die aktuelle Version besteht aus einer Art "Arena-System", wobei jede Arena jeweils eine zuvor definierte Anzahl an verschiedenen Monstern
beherbergt. Der Spieler bekämpft dies Kreaturen mit dem Ziel die Arena gäntlich von ihnen zu befreien.

Wie schon beim Kampfsystem konnte ich auch bei der Handlung des Spiels nicht alle meine ursprünglichen Ideen einbauen. Ich hatte beispielsweise angedacht,
einige versteckte Gegenstände in den einzelnen Räumen unterzubringen. Diese Gegenstände hätte der User durch das Beenden von Arenen sammeln soll um schlussendlich die finale Arena und somit das Ende des Spiels freizuschalten. Gegebenenfalls werde ich diese Funktion nach der Abgabe des Projekts noch privat implementieren.

![Story One](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/story1.png)

## Testen

### Testprotokoll:

| # | Kategorie | Testfall | Resultat
|--|--|--|--|
| 1 | Funktionalität | Das Programm kann gestartet werden | Erfüllt |
| 2 | Funktionalität | Ein vollständiger Durchlauf des Programms ist möglich | Erfüllt |
| 3 | Nutzereingabe| Usereingabe werden stehts auf Validität überprüft und geben falls notwendig eine Fehlermeldung zurück |  Erfüllt |
| 4 | Nutzereingabe| User kann Eingabe über eine Auswahl an "keywords" tätigen. Es gibt nicht nur 1 richtigen Weg | Teils Erfüllt |
| 5 | Nutzereingabe| User kann "Charakter" erstellen | Erfüllt |
| 6 | Kampfsystem| User kann gegen mehrere, unerschiedlich starke Monster antreten |Erfüllt|
| 7 | Kampfsystem| User kann durch Entscheidungen Kämpfe gegen Monster beeinflussen |Erfüllt|
| 8 | Story| Spiel verfügt über eine zusammenhängende Geschichte, auf welcher der Nutzer Einfluss nehmen kann | Nicht Erfüllt|
| 8 | Story| Items können im Lauf des Spiels gesammelt werden | Nicht Erfüllt|

