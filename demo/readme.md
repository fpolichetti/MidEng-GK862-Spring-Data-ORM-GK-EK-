Pojekt: Lagerverwaltungssystem

Besprochene Probleme:

1. Verwendung von Listen als Attributtypen: Ursprünglich wurden `ArrayList<String>` und `ArrayList<Integer>` in der Klasse `Warehouse` verwendet, um Artikel und ihre Preise zu speichern. Dies führte zu Fehlern beim Einsatz von JPA, da JPA einfache Attributtypen erwartet, die keine Container sind.

2. Mangelnde Strukturierung der Daten: Das ursprüngliche Design des `Warehouse`-Objekts ließ keine klare Trennung zwischen verschiedenen Entitäten wie Lager, Artikel und Preisen zu. Dies führte zu einer weniger flexiblen und schwer wartbaren Datenstruktur.

3. Fehlende Verwendung von JPA-Annotationen: Einige Attribute in der `Warehouse`-Klasse wurden nicht mit JPA-Annotationen versehen, was zu Fehlern oder unerwünschtem Verhalten führen kann, insbesondere wenn das Objekt mit einer Datenbank verbunden ist.


Mögliche Probleme:

1. Datenkonsistenz: Ohne eine klare Strukturierung der Daten und eine angemessene Verwendung von JPA-Annotationen besteht das Risiko inkonsistenter Daten, insbesondere wenn das System in einer Datenbank persistiert wird.

2. Performanzprobleme: Wenn große Datenmengen verarbeitet werden müssen, könnten ineffiziente Datenstrukturen oder Datenbankabfragen zu Leistungsproblemen führen.

3. Anforderungsänderungen: Da Anforderungen an das Lagerverwaltungssystem möglicherweise nicht vollständig spezifiziert wurden, könnten während der Entwicklung neue Anforderungen auftreten, die das Design und die Implementierung beeinflussen.


Um diese Probleme anzugehen, wurde das Projekt umstrukturiert, um eine klarere Entitätsstruktur zu ermöglichen und die Verwendung von JPA-Annotationen zu optimieren. Durch die Verwendung von Entitätsklassen für Lager, Artikel und Preise sowie die Definition von Beziehungen zwischen diesen Klassen kann das Lagerverwaltungssystem flexibler, wartbarer und besser an zukünftige Anforderungen anpassbar sein.