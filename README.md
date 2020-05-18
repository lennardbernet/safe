## Zeit Managment:

04.05.2020 16:30 - 17:10
Projekt erstellt, Konzept erabeitet

11.05.2020 16:30 - 17:10
Grunsätze vom Projekt angefangen zu implementieren

11.05.2020 16:30 - 20:00
Projekt abgeschlossen.

Leider war die Zeit viel zu knapp bemessen. Trotz den 2h Überzeit wurden wir nicht fertig.
Unsere Projekt funktionert nicht. Sie müssen sich im Code zurecht finden

##### Was haben wir geschaft:
 - SHA512 Verschlüsselung für das Login
 - AES Verschlüsselung für die Passwörter
 - ansätzliche DB einbindung
 
##### TODOs
 - Projekt zum laufen  bringen (Navigation, funktionierte Buttons).
 - DB zum laufen bringen 
 
### Fazit
Wir finden es sehr schade das wir so wenig Zeit für das Projekt bekommen haben. Der Code hat darunter stark gelitten. 
Die Projekt Idee finden wir ansich sehr intressant und wir sind mit dem Produkt zufrieden. 


## Dario Gedanken
Wir benutzen für das Login sha512 Verschlüsselung und für das Dashboard die AES Verschlüsselung.
Das Login ist relativ sicher da eine sha512 nich rückverschlüsselbar ist. Es wäre nicht so schlimm, wenn ein Hacker das Verschlüsselte Master Password in die Hände bekommen würde.
Das Dashboard hingegen ist weniger sicher da wir den Key einfach hardcoden. Wenn der Hacker den Key rausfindet und zusätzliche unsere DB häckt kann er alle Paswörter entschlüsseln.
Jedoch läuft Springboot auf einem Server, was es nicht so einfacht macht unser Dashboard zu hacken. 

## Lennard Gedanken
Das Login ist sehr sicher. Das Passwort liegt schon auf der Datenbank mit sha-512 Verschlüsselung. Dadurch muss man im Programm nur verschlüsseln und nicht entschlüsseln. Beim Dashboard sieht dies etwas anders aus, weil wir die verschlüsselten Werte der Datenbank entschlüsselt anzeigen müssen. Da wir dafür einen Key brauchen und den hardcoden im Quellcode ist das ganze nicht sicher. Ebenfalls ist für das Dashboard keine Authentifizierung vorhanden, was aber auch nicht ein Teil des Auftrages war. 
