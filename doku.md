#Dario Gedanken
Wir benutzen für das Login sha512 Verschlüsselung und für das Dashboard die AES Verschlüsselung.
Das Login ist relativ sicher da eine sha512 nich rückverschlüsselbar ist. Es wäre nicht so schlimm, wenn ein Hacker das Verschlüsselte Master Password in die Hände bekommen würde.
Das Dashboard hingegen ist weniger sicher da wir den Key einfach hardcoden. Wenn der Hacker den Key rausfindet und zusätzliche unsere DB häckt kann er alle Paswörter entschlüsseln.
Jedoch läuft Springboot auf einem Server, was es nicht so einfacht macht unser Dashboard zu hacken. 

#Lennard Gedanken
Das Login ist sehr sicher. Das Passwort liegt schon auf der Datenbank mit sha-512 Verschlüsselung. Dadurch muss man im Programm nur verschlüsseln und nicht entschlüsseln. Beim Dashboard sieht dies etwas anders aus, weil wir die verschlüsselten Werte der Datenbank entschlüsselt anzeigen müssen. Da wir dafür einen Key brauchen und den hardcoden im Quellcode ist das ganze nicht sicher. Ebenfalls ist für das Dashboard keine Authentifizierung vorhanden, was aber auch nicht ein Teil des Auftrages war. 