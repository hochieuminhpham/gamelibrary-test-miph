## 1. Testobjekt
Diese ganze Applikation namens GamesLibrary ist das Testobjekt. Folgendes hat es:

Backend (Ordner) -> Java / Springboot -> Geschäftslogik (GameService, TitleNormalizer), Controller, Model und Repository

Frontend (Ordner) -> HTML / TS / CSS -> Benutzeransicht

## 2. Teststufen
Unittests: isolierte Tests einzelner Klassen oder Methoden (JUnit 5, Mockito, Verify) -> GameServiceTest oder TitleNormalizerTest

Integrationtest: Zusammenspiel verschiedener Klassen oder Komponenten testen

End to End Test: Aus Benutzeransicht Use-Case simulieren mit Express.

## 3. Entwicklungsvorgehen:
TDD
CI-Pipeline
Deployment simulieren

TODO:
Rollen
Infrastruktur
Testfall erstellen
Durchführung
Fehlerbehandlung