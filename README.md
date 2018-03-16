Norint paleisti servisą reikia paleisiti komandas:

`docker build -t webservisas:1 .`

`docker run -d --net=host webservisas:1`

Servisas pasiekiamas: http://localhost:5000/temperatura/konverteris/
