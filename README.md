# da-poker
DA - poker oppgave

## Antagelser

* Ess rangeres som høyeste kort, ikke laveste.

## Funksjonalitet

Programmet skal kunne identifisere følgende pokerhender:
• Par
• To par
• Tre like
• Straight (sekvens av fem påfølgende kort, uavhengig av sort)
• Flush (alle kort i samme sort)
• Fullt hus (tre like + ett par)
• Fire like
• Straight flush (sekvens av fem påfølgende kort i samme sort)

## Bygge og kjøre

mvn compile
java.exe -cp target\classes no.domstol.da.poker.Poker

mvn package
java.exe -cp target\poker-1.0-SNAPSHOT.jar no.domstol.da.poker.Poker
