# Xmen

Challenge de proyecto basandose en adn para identificar humanos o mutantes

## Comenzando 🚀

Para ejecutar el proyecto local se debe clonar el proyecto ejecutar el comando 'gradle build clean' y posteriormente levantar la aplicacion

### Pre-requisitos 📋

Se debe tener instalado como minimo la version 1.8 de java


### Instalación 🔧

Luego de compilada la aplicacion con el comando 'gradle build' se podria y si no se quiere ejecutar desde el IDE, ejecutar en un cmd 
que se encuentre en la ruta donde este el codigo fuente y dentro de la siguiente carpeta application\app-service\build\libs, el comando
java -jar app.jar y posterior en un navegador realizar las peticiones.

### Como realizar peticiones 🚀

* NOTA
	La aplicacion fue desplegada en Heroku y GCP, aunque desplego la aplicacion completa y compila posterior a esto no esta ejecutando el jar en ambas plataformas.
	aun asi dejo en la documentacion la informacion de dichos endpoints en dichas plataformas y la info en local que esta apuntando al bd en GCP.

* Heroku
	*https://mutantmanuel.herokuapp.com/actuator/health (GET)  >> Endpoint para validar si la app esta arriba conectada con la bd
	*https://mutantmanuel.herokuapp.com/mutant/stats    (GET)  >> Endpoint que devuelve el promedio de mutantes y conteo de mutantes y humanos
	*https://mutantmanuel.herokuapp.com/mutant 		   (POST) >> Endpoint para enviar la cadena de adn y esperar un 200 si es mutante o 403 si es humano
	
	ejemplo del body
	{       
    "dna": ["ATGCGA", "CAGTGC", "TTATGT","AGAAGG", "CCCCTA", "TCACTZ"]    
	}
	
	*https://mutantmanuel.herokuapp.com/swagger-ui.html (GET)  >> Endpoint que se debe ejecutar desde el navgador para visualizar la documentacion de las metodos expuestos en la api
	
* GCP
	*https://xmengcp.uc.r.appspot.com/actuator/health (GET)  >> Endpoint para validar si la app esta arriba conectada con la bd
	*https://xmengcp.uc.r.appspot.com/mutant/stats    (GET)  >> Endpoint que devuelve el promedio de mutantes y conteo de mutantes y humanos
	*https://xmengcp.uc.r.appspot.com/mutant 		   (POST) >> Endpoint para enviar la cadena de adn y esperar un 200 si es mutante o 403 si es humano
	
	ejemplo del body
	{       
    "dna": ["ATGCGA", "CAGTGC", "TTATGT","AGAAGG", "CCCCTA", "TCACTZ"]    
	}
	
	*https://xmengcp.uc.r.appspot.com/swagger-ui.html (GET)  >> Endpoint que se debe ejecutar desde el navgador para visualizar la documentacion de las metodos expuestos en la api

* Local
	*http://localhost:8081/actuator/health (GET)  >> Endpoint para validar si la app esta arriba conectada con la bd
	*http://localhost:8081/mutant/stats    (GET)  >> Endpoint que devuelve el promedio de mutantes y conteo de mutantes y humanos
	*http://localhost:8081/mutant 		   (POST) >> Endpoint para enviar la cadena de adn y esperar un 200 si es mutante o 403 si es humano
	
	ejemplo del body
	{       
    "dna": ["ATGCGA", "CAGTGC", "TTATGT","AGAAGG", "CCCCTA", "TCACTZ"]    
	}
	
	*http://localhost:8081/swagger-ui.html (GET)  >> Endpoint que se debe ejecutar desde el navgador para visualizar la documentacion de las metodos expuestos en la api


## Despliegue 📦

El despliegue del proyecto se realizo en heroku y en gcp.

## Construido con 🛠️

* Gradle
* Java 
* Spring Boot
* Postgresql

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Manuel Alejandro Lopez Gutierrez** - *Desarrollador* 

