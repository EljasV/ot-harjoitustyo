
# OT Harjoitustyö
Oletko halunnut aina chattailla samalla koneella olevien kanssa? Tässä on uusi mahdollisuutesi!


## Julkaisut
[1. julkaisu viikolla 5](https://github.com/EljasV/ot-harjoitustyo/releases/tag/viikko5)


## Ohjelman suorittaminen
Ohjelma voidaan kääntää ja suorittaa seuraavalla komennolla:

```mvn compile exec:java -Dexec.mainClass=veijalainen.eljas.otharjoitustyo.Main```

## Ohjelman testaaminen
Ohjelman testit voidaan suorittaa komennolla:

```mvn test```


Ohjelman testikattavuusraportti luodaan seuraavalla komennolla:

```mvn test jacoco:report```

Testikattavuusraportti luodaan tiedostoon [./target/site/jacoco/index.html](./target/site/jacoco/index.html)

## Checkstyle
Ohjelman tyyli voidaan tarkistaa checkstylen avulla

```mvn jxr:jxr checkstyle:checkstyle```

Checkstyle -raportti luodaan tiedostoon [./target/site/checkstyle.html](./target/site/checkstyle.html)

## .jar-tiedosto
.jar-tiedosto kasataan seuraavalla komennolla

```mvn package```

Tiedosto ilmestyy kansioon [./target](./target)

Tiedosto voidaan suorittaa komennolla:

```java -jar ot-harjoitustyo-1.0.0.jar```

Jos olet projektin juurikansiossa, suoritus tehdään komennolla

(Windows)``java -jar target\ot-harjoitustyo-1.0.0.jar``

(Linux)``java -jar target/ot-harjoitustyo-1.0.0.jar``


## Javadoc
Projektin javadoc voidaan generoida komennolla
```mvn javadoc:javadoc```

## Dokumentaatio
[Vaatimusmäärittely](./dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](./dokumentaatio/tuntikirjanpito.md)

[Changelog](./dokumentaatio/changelog.md)

[Arkkitehtuuri](./dokumentaatio/arkkitehtuuri.md)