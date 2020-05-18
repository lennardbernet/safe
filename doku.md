#Dario Gedanken
Wir benutzen für das Login sha512 Verschlüsselung und für das Dashboard die AES Verschlüsselung.
Das Login ist relativ sicher da eine sha512 nich rückverschlüsselbar ist. Es wäre nicht so schlimm, wenn ein Hacker das Verschlüsselte Master Password in die Hände bekommen würde.
Das Dashboard hingegen ist weniger sicher da wir den Key einfach hardcoden. Wenn der Hacker den Key rausfindet und zusätzliche unsere DB häckt kann er alle Paswörter entschlüsseln.
Jedoch läuft Springboot auf einem Server, was es nicht so einfacht macht unser Dashboard zu hacken. 

#Lenhard Gedanken