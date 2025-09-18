# Domstoladministrasjonen - poker oppgave

## Antagelser

* Rangering av kategorier og pokerhender basert på https://en.wikipedia.org/wiki/List_of_poker_hands
* Ess rangeres som høyeste kort, ikke laveste.
* Sammenligninger basert på at alle hender trekkes fra en enkelt standard kortstokk, som implisitt begrenser mulige kombinasjoner.

## Funksjonalitet

(fra oppgaven) Programmet skal kunne identifisere følgende pokerhender:
- Par
- To par
- Tre like
- Straight (sekvens av fem påfølgende kort, uavhengig av sort)
- Flush (alle kort i samme sort)
- Fullt hus (tre like + ett par)
- Fire like
- Straight flush (sekvens av fem påfølgende kort i samme sort)

Programmet trekker to hender fra en tilfeldig blandet kortstokk, identifiserer hver hand etter poker regler som nevnt over og gjør en sammenligning mellom de to hendene som avgjør om den ene er bedre enn den andre eller om de er like gode. Resultatene skrives ut med en notasjon som bruker symboler og tall som er typiske for kortspill.

For å se symboler for kortenes sort (hjerter, ruter, spar, kløver) må terminal være konfigurert for utf8 tegnsett og bruke fonter som støtter disse symbolene.

Om symboler ikke virker kan det slås av og på med -Dbruksymboler=true/false

## Bygge og kjøre

> mvn compile
> java.exe -cp target\classes no.domstol.da.poker.Poker

eller

> mvn package
> java.exe -cp target\poker-1.0-SNAPSHOT.jar no.domstol.da.poker.Poker

Uten symboler for sort:

> java.exe -cp target\poker-1.0-SNAPSHOT.jar -Dbruksymboler=false no.domstol.da.poker.Poker
