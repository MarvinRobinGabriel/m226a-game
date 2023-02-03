## m226a - Adventure Game

Für das Informatikmodul m226a, welches ich von November 2022 bis in den frühen Februar 2023
an der Technischen Beruffschule Zürich besuchte, entwickelte ich ein textbasiertes Adventurespiel mit Java.

### Planung
Um bereits zu Beginn meiner Arbeit einen guten Überblick und ein
tiefes Verständnis meines Spiels aufzubauen, plante ich eine grobe Struktur meines
Abenteuerspiels mithilfe eines Klassendiagramms

![Klassendiagramm](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/klassendiagramm.png)

Nachdem ich bereits einige Funktionalitäten entwickelt und eine
genauere Vorstellung des finalen Produkts hatte, erstellte ich zusätzlich
zum Klassendiagramm ein Sequenzdiagramm, welches die typische Nutzererfahrung mit dem Spiel aufzeigt.

![Sequenzdiagramm](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/sequenzdiagramm.png)

### Entwicklung
In der 3 wöchigen Entwicklungsperiode investierte ich etwa 10 Stunden in das Projekt.
Mir war schon früh bewusst, dass ich durch eine Art "GameEngine" viele, oft verwendete, Funktionen
zentralisieren und somit Wiederverwendbar machen konnte.

**GameEngine:**

Mithilfe der Game Engine konnte ich beispielsweise durch eine Methode die Textausgabe
im Terminal (Farbe, Textstärke) ohne grossen Aufwand festlegen. 

![GameEngineThree](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine3.png)
![GameEngineOne](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine1.png)
![GameEngineTwo](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine2.png)

Ein ähnliches Prinzip verwendete ich, um die Usereingabe verschiedener Commands zu handeln.
![GameEngine Four](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine4.png)
![GameEngine Five](https://github.com/MarvinRobinGabriel/m226a-game/blob/main/docs/engine5.png)


